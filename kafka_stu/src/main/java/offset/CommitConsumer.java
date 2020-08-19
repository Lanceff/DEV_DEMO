package offset;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-29 08:11
 **/
public class CommitConsumer {
    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group20");
        //配置不自动提交，需要手动提交
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //2.创建Topic消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
        //3.订阅主题
        consumer.subscribe(Arrays.asList("topic1"));

        LocalDateTime start = LocalDateTime.now();
        while (LocalDateTime.now().isBefore(start.plusMinutes(1))) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            Iterator<ConsumerRecord<String, String>> iterator = records.iterator();
            while (iterator.hasNext()) {
                ConsumerRecord<String, String> record = iterator.next();
                String key = record.key();
                String value = record.value();
                long offset = record.offset();
                int partition = record.partition();
                //手动提交需要传递的参数组合
                Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                offsets.put(new TopicPartition(record.topic(), partition), new OffsetAndMetadata(offset + 1));
                //手动提交offset
                consumer.commitAsync(offsets, new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                        System.out.println("完成：" + offset + "提交！");
                    }
                });
                System.out.println("key:" + key + ",value:" + value + ",partition:" + partition + ",offset:" + offset);
            }
        }
        consumer.close();
    }
}
