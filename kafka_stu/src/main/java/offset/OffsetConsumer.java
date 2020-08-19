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
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group04");
        /**
         * earliest: ������û��ƫ������Ϣʱ������Ϣ������λ�ÿ�ʼ
         * latest: ������û��ƫ������Ϣʱ������Ϣ������λ��
         * none: ������û��ƫ������Ϣʱ�����쳣
         * anything else: throw exception to the consumer.
         */
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        //Consumer�ύoffsetֵ��zookeeper�����ڣ��µ�������������������������ʱ�����ر��ˣ���ô���ظ�����
        config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,10000);
        //2.����Topic������
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
        //3.��������
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
