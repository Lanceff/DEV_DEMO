package idempotent;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @description: �ݵ��ԣ���֤����ֻ����һ�Σ�������д�������Я��PID,Seq����д��֮ǰ��Ƚ�kafka��ӦPID��CurrentSeq��
 * ���seq>CurrentSeq,��ɹ�д�룬CurrentSeq���£���������㣬˵�����ظ����ݣ�������д��
 * @author: Lance
 * @create: 2020-07-29 15:34
 **/
public class IdempotentProducer {
    public static void main(String[] args) {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //�����߷�����Ϣ��kafka��ȷ�Ϸ��ͳɹ��ĳ�ʱʱ�䣬����1ms���ڲ����������ظ�������Ϣ�ĳ���
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1);

        /**
         * kafka�����ݵ�д����֤���ظ�д��
         * �ݵ��Ա������� max.in.flight.requests.per.connectionС�ڻ����5��retries����0,acks����Ϊall(-1)������û�δ��ȷ������Щֵ����ѡ����ʵ�ֵ
         */
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        //���ƿͻ����ڵ����������ܹ����͵�δ��Ӧ����ĸ��������ô�ֵ��1��ʾkafka broker����Ӧ����֮ǰclient��������ͬһ��broker�����������ô˲�����Ϊ�˱�����Ϣ����
        config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        //��Ϣȷ�ϳ�ʱ�����Դ���,ȷ�����ݲ���ʧ
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        config.put(ProducerConfig.ACKS_CONFIG, "all");

        //2.����������
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        //3.������Ϣ
        ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "lance");
        producer.send(record);
        producer.close();
    }

}
