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
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group20");
        //���ò��Զ��ύ����Ҫ�ֶ��ύ
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //2.����Topic������
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
        //3.��������
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
                //�ֶ��ύ��Ҫ���ݵĲ������
                Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                offsets.put(new TopicPartition(record.topic(), partition), new OffsetAndMetadata(offset + 1));
                //�ֶ��ύoffset
                consumer.commitAsync(offsets, new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                        System.out.println("��ɣ�" + offset + "�ύ��");
                    }
                });
                System.out.println("key:" + key + ",value:" + value + ",partition:" + partition + ",offset:" + offset);
            }
        }
        consumer.close();
    }
}
