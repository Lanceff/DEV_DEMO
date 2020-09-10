package com.hui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hui.pojo.CarBrand;
import com.hui.server.CarBrandService;
import com.hui.util.ESClient;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.sniff.ElasticsearchNodesSniffer;
import org.elasticsearch.client.sniff.NodesSniffer;
import org.elasticsearch.client.sniff.SniffOnFailureListener;
import org.elasticsearch.client.sniff.Sniffer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class ESStuTest {

    @Resource
    private CarBrandService carBrandService;

    @Test
    public void getHighLevelClient() {
        RestHighLevelClient client = ESClient.getInstance().getHighLevelClient();
        //client.close();
        ESClient.getInstance().closeClient();
    }

    //嗅探器
    @Test
    public void sniffer() throws IOException {
        //region 监听器
        SniffOnFailureListener sniffOnFailureListener = new SniffOnFailureListener();
        //region 1:获取Clients
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")
        ).setFailureListener(sniffOnFailureListener).build();//设置用于监听嗅探失败的监听器 绑定监听器
        //endregion

        //region 2:使用HTTPS
        NodesSniffer nodesSniffer = new ElasticsearchNodesSniffer(
                restClient,
                ElasticsearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT,
                ElasticsearchNodesSniffer.Scheme.HTTPS);
        //endregion

        //region 3:为RestClient绑定嗅探器
        Sniffer sniffer = Sniffer.builder(restClient)
                .setSniffIntervalMillis(5000)//每隔多久嗅探一次
                .setSniffAfterFailureDelayMillis(30000) //若没有绑定监听器则无效 嗅探失败时候触发嗅探一次 经过设置的时间之后再次嗅探 直至正常
                .setNodesSniffer(nodesSniffer)//如果要使用HTTPS 必须设置的对象
                .build();
        //endregion

        //启用监听
        sniffOnFailureListener.setSniffer(sniffer);
        //注意释放嗅探器资源 关闭嗅探器必须在client关闭之前操作
        sniffer.close();
        restClient.close();
    }

    //region 测试自动探查节点
    @Test
    public void snifferTest() throws InterruptedException {
        RestHighLevelClient client = ESClient.getInstance().getHighLevelClient();
        /* while (true) {
            Thread.sleep(5000);
            System.out.println(client);
        }*/
        Iterator<Node> nodes = client.getLowLevelClient().getNodes().iterator();
        while (nodes.hasNext()) {
            Node node = nodes.next();
            System.out.println(node);
        }
        Thread.sleep(5000);
        System.out.println("2000年后:");
        nodes = client.getLowLevelClient().getNodes().iterator();
        while (nodes.hasNext()) {
            Node node = nodes.next();
            System.out.println(node);
        }
        ESClient.getInstance().closeClient();
    }
    //endregion

    @Test
    public void bulkInit() throws IOException {
        RestHighLevelClient client = ESClient.getInstance().getHighLevelClient();
        GetIndexRequest request = new GetIndexRequest("car_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        if (!exists) {
            CreateIndexRequest createRequest = new CreateIndexRequest("car_index");
            createRequest.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
            CreateIndexResponse createIndexResponse = client.indices().create(createRequest, RequestOptions.DEFAULT);
        }
        List<CarBrand> list = carBrandService.list();
        //批量插入数据，更新和删除同理
        BulkRequest bulkRequest = new BulkRequest("car_index");
        for (int i = 0; i < list.size(); i++) {
            bulkRequest.add(new IndexRequest().id(Integer.toString(i)).source(list.get(i), XContentType.JSON));
        }
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("数量:" + response.getItems().length);
        ESClient.getInstance().closeClient();
    }
}
