package offset;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-29 08:11
 **/
public class OffsetConsumer {
    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group04");
        /**
         * earliest: 消费者没有偏移量信息时，从消息的最先位置开始
         * latest: 消费者没有偏移量信息时，从消息的最新位置
         * none: 消费者没有偏移量信息时，抛异常
         * anything else: throw exception to the consumer.
         */
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        //Consumer提交offset值到zookeeper的周期，新的消费者组如果在消费完后到配置时间间隔关闭了，那么将重复消费
        config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,10000);
        //2.创建Topic消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
        //3.订阅主题
        consumer.subscribe(Arrays.asList("topic1"));
        
        LocalDateTime start = LocalDateTime.now();
        while (LocalDateTime.now().isBefore(start.plusSeconds(30))) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            Iterator<ConsumerRecord<String, String>> iterator = records.iterator();
            while (iterator.hasNext()) {
                ConsumerRecord<String, String> record = iterator.next();
                String key = record.key();
                String value = record.value();
                long offset = record.offset();
                int partition = record.partition();
                System.out.println("key:" + key + ",value:" + value + ",partition:" + partition + ",offset:" + offset);
            }
        }
        consumer.close();
    }
}
