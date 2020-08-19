package transactions;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author: Lance
 * @Date: 2020-07-30 11:07
 * @Description: 上游消息生产、用于测试 生产者、消费者事务
 */
public class TestTransactionProducer {

    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //消息确认超时后重试次数
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        //2.创建生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        //3.发送消息
        for (int i = 1; i <= 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "tkey" + i, "transaction value" + i);
            producer.send(record);
        }
        producer.close();
    }
}
