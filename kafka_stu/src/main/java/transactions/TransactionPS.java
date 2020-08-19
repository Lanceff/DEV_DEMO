package transactions;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.*;

/**
 * @author: Lance
 * @Date: 2020-07-30 10:30
 * @Description: ������&����������
 * 1.producer1����topic1��Ϣ->kafka
 * ==����������
 * 2.consumer1 ����kafka��topic1����Ϣ�����õ�����Ϣ��һЩ������߼���������µ���Ϣ
 * 3.producer2 ������������Ϣ���͸�����topic2��
 * ==���ύ�����ύconsumer1ƫ����offset���ύ producer2��topic2������Ϣ��kafka��
 * 4.consumer2 ����topic2�е�����Ϣ
 */
public class TransactionPS {

    public static void main(String[] args) {
        KafkaConsumer consumer = initConsumer("group1");
        KafkaProducer producer = initProducer();
        //
        consumer.subscribe(Arrays.asList("topic1"));
        //��ʼ������
        producer.initTransactions();
        try {

            while (true) {
                //���ѻ�ȡԭʼ����
                ConsumerRecords records = consumer.poll(Duration.ofSeconds(1));
                if (!records.isEmpty()) {
                    Iterator<ConsumerRecord<String, String>> iterator = records.iterator();
                    Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                    /**
                     * �����������
                     */
                    producer.beginTransaction();
                    while (iterator.hasNext()) {
                        //��ȡԭʼ������Ϣ
                        ConsumerRecord<String, String> record = iterator.next();
                        //����ԭʼ���ݺ��͵��µĵ�topic
                        producer.send(new ProducerRecord<>("topic03", record.key(), record.value() + "<auth ff>"));
                        //��¼Ҫ�ύ��ƫ����
                        offsets.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1));
                        if (Integer.parseInt(record.key().substring(4)) == 6) {
                            if (Integer.parseInt(record.key().substring(4)) == 6) {
                                int i = 1 / 0;
                            }
                        }
                    }
                    /**
                     * �ύ����,ֻ�е����������߳ɹ��������ݺ󣬲����ύ���ε�������ƫ����
                     */
                    producer.sendOffsetsToTransaction(offsets, "group8");
                    producer.commitTransaction();
                }
            }
        } catch (Exception e) {
            producer.abortTransaction();
            System.err.println(e.toString());
        } finally {
            consumer.close();
            producer.close();
        }
    }

    public static KafkaProducer initProducer() {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //����idΨһ��
        config.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "transaction_id");
        //2.����������
        return new KafkaProducer<String, String>(config);
    }

    public static KafkaConsumer initConsumer(String group) {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        //�ر��Զ��ύ
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
        return new KafkaConsumer<String, String>(config);
    }
}
