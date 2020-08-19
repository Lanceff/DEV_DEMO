package offset;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import partitioner.MyPartitioner;

import java.util.Properties;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-29 08:11
 **/
public class Producer {

    public static void main(String[] args) {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //2.����������
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        //3.������Ϣ
        for (int i = 1; i <= 12; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "v" + i);
            producer.send(record);
        }
        producer.close();
    }
}
