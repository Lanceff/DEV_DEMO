package serializer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-28 14:47
 **/
public class Producer {

    public static void main(String[] args) {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MySerializer.class.getName());

        //2.����������
        KafkaProducer<String, Person> producer = new KafkaProducer<>(config);
        //3.������Ϣ
        for (int i = 1; i <= 10; i++) {
            Person p = new Person();
            p.setAge(new Random().nextInt(10) + 10);
            p.setName("user" + i);
            p.setSex(i % 2 == 1 ? "��" : "Ů");
            ProducerRecord<String, Person> record = new ProducerRecord<>("topic1", p);
            producer.send(record);
        }
        producer.close();
    }
}
