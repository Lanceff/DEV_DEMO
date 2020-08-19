package transactions;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.requests.IsolationLevel;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author: Lance
 * @Date: 2020-07-30 09:47
 * @Description:
 */
public class Consumer {

    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group15");
        /*config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,"read_committed");//读已提交*/
        config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,"read_uncommitted"); //读未提交，会脏读
        //2.创建Topic消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
        //3.订阅topic开头的消息队列
        consumer.subscribe(Arrays.asList("topic03"));

        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            if (!consumerRecords.isEmpty()) {
                Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
                while (recordIterator.hasNext()) {
                    ConsumerRecord<String, String> record = recordIterator.next();
                    String key = record.key();
                    String value = record.value();
                    long offset = record.offset();
                    int partition = record.partition();
                    System.out.println("key:" + key + ",value:" + value + ",partition:" + partition + ",offset:" + offset);
                }
            }
        }
    }
}
