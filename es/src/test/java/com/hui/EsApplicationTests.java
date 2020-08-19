package com.hui;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EsApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("my_index2");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        if (createIndexResponse.isAcknowledged()) {
            System.out.println("创建index成功");
        } else {
            System.out.println("创建index失败");
        }

        client.close();
    }

    @Test
    public void getIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("my_index*");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        String[] indices = response.getIndices();
        for (String indexName : indices) {
            System.out.println("index name:" + indexName);
        }
        client.close();
    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("my_index*");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        if (response.isAcknowledged()) {
            System.out.println("删除index成功");
        } else {
            System.out.println("删除index失败");
        }
        client.close();
    }

    /**
     * 插入数据
     *
     * @throws IOException
     */
    @Test
    public void insertData() throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "Lance");
        jsonMap.put("postDate", LocalDate.now().format(df));
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest request = new IndexRequest("my_index1").id("1").source(jsonMap);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        client.close();
    }

    /**
     * 批量插入数据
     *
     * @throws IOException
     */
    @Test
    public void batchInsertData() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("my_index2").id("4").source(XContentType.JSON, "name", "foo", "age", 18, "date", LocalDate.now().format(df)));
        request.add(new IndexRequest("my_index2").id("5").source(XContentType.JSON, "name", "bar", "age", 20, "date", LocalDate.now().format(df)));
        request.add(new IndexRequest("my_index2").id("6").source(XContentType.JSON, "name", "baz", "age", 30, "date", LocalDate.now().format(df)));
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 获取全部数据
     */
    @Test
    void getById() throws IOException {
        GetRequest request = new GetRequest("my_index2", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        response.getSource().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        client.close();
    }

    /**
     * 根据文档id删除文档
     *
     * @throws IOException
     */
    @Test
    public void delById() throws IOException {
        DeleteRequest request = new DeleteRequest("my_index2", "3");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
        client.close();
    }

    @Test
    public void multiGetById() throws IOException {
        //多个根据id查询
        MultiGetRequest request = new MultiGetRequest();
        request.add("my_index2", "1");
        //两种写法
        request.add(new MultiGetRequest.Item("my_index2", "2"));
        MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
        for (MultiGetItemResponse itemResponse : response) {
            System.out.println(itemResponse.getResponse().getSourceAsString());
        }
        client.close();
    }

    @Test
    public void multiGetAll() throws IOException {
        SearchRequest request = new SearchRequest("my_index2");
        SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
        /*searchBuilder.query(QueryBuilders.matchAllQuery());*/
        searchBuilder.query(QueryBuilders.rangeQuery("age").gt(22).lte(24));
        searchBuilder.from(0);
        searchBuilder.size(5);
        request.source(searchBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        response.getHits().forEach((v) -> {
            System.out.println(v.getSourceAsString());
        });
        client.close();
    }

    @Test
    public void updateByQuery() throws IOException {
        UpdateByQueryRequest request = new UpdateByQueryRequest("my_index2");
        //默认情况下，版本冲突会中止 UpdateByQueryRequest 进程，但是你可以用以下命令来代替
        //设置版本冲突继续
        //request.setConflicts("proceed");
        //设置更新条件
        request.setQuery(QueryBuilders.matchQuery("age", 25));
        //限制更新条数
        //request.setMaxDocs(10);
        request.setScript(new Script(ScriptType.INLINE, "painless", "ctx._source.name='lance';", Collections.emptyMap()));
        BulkByScrollResponse response = client.updateByQuery(request, RequestOptions.DEFAULT);
        System.out.println(response);
        client.close();
    }

    @Test
    public void aggsAge() throws IOException {
        SearchRequest request = new SearchRequest("my_index2");
        SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("name_term") .field("name.keyword");
        searchBuilder.aggregation(aggregation);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response);
        client.close();
    }
}
