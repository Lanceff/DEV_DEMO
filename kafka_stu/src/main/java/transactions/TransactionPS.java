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
 * @Description: 生产者&消费者事务。
 * 1.producer1生产topic1消息->kafka
 * ==》开启事务
 * 2.consumer1 消费kafka中topic1的消息，对拿到的消息做一些额外的逻辑处理，组成新的消息
 * 3.producer2 将处理后的新消息发送给下游topic2中
 * ==》提交事务（提交consumer1偏移量offset、提交 producer2的topic2主题消息到kafka）
 * 4.consumer2 消费topic2中的新消息
 */
public class TransactionPS {

    public static void main(String[] args) {
        KafkaConsumer consumer = initConsumer("group1");
        KafkaProducer producer = initProducer();
        //
        consumer.subscribe(Arrays.asList("topic1"));
        //初始化事务
        producer.initTransactions();
        try {

            while (true) {
                //消费获取原始数据
                ConsumerRecords records = consumer.poll(Duration.ofSeconds(1));
                if (!records.isEmpty()) {
                    Iterator<ConsumerRecord<String, String>> iterator = records.iterator();
                    Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                    /**
                     * 开启事务控制
                     */
                    producer.beginTransaction();
                    while (iterator.hasNext()) {
                        //获取原始数据信息
                        ConsumerRecord<String, String> record = iterator.next();
                        //处理原始数据后发送到新的的topic
                        producer.send(new ProducerRecord<>("topic03", record.key(), record.value() + "<auth ff>"));
                        //记录要提交的偏移量
                        offsets.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1));
                        if (Integer.parseInt(record.key().substring(4)) == 6) {
                            if (Integer.parseInt(record.key().substring(4)) == 6) {
                                int i = 1 / 0;
                            }
                        }
                    }
                    /**
                     * 提交事务,只有等下游生产者成功发送数据后，才能提交上游的消费者偏移量
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
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //事务id唯一性
        config.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "transaction_id");
        //2.创建生产者
        return new KafkaProducer<String, String>(config);
    }

    public static KafkaConsumer initConsumer(String group) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        //关闭自动提交
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
        return new KafkaConsumer<String, String>(config);
    }
}
