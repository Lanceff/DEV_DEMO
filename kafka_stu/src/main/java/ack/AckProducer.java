package ack;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @description: ack���ƣ����ܵ��������������ظ�����
 * @author: Lance
 * @create: 2020-07-29 14:17
 **/
public class AckProducer {

    public static void main(String[] args) {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //�����߷�����Ϣ��kafka��ȷ�Ϸ��ͳɹ��ĳ�ʱʱ�䣬����1ms���ڲ����������ظ�������Ϣ�ĳ���
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1);
        /**
         * producer��Ҫserver���յ�����֮�󷢳���ȷ�Ͻ��յ��źţ��������þ���ָprocuder��Ҫ���ٸ�������ȷ���źš�������ʵ���ϴ��������ݱ��ݵĿ����ԡ���������Ϊ����ѡ�
         * acks=0�� ����Ϊ0��ʾproducer����Ҫ�ȴ��κ�ȷ���յ�����Ϣ�������������ӵ�socket  buffer����Ϊ�Ѿ����͡�
         *          û���κα��Ͽ��Ա�֤���������server�Ѿ��ɹ��������ݣ�ͬʱ�������ò��ᷢ�����ã���Ϊ�ͻ��˲�֪���Ƿ�ʧ�ܣ�������offset����������Ϊ-1��
         * acks=1�� ����ζ������Ҫ�ȴ�leader�Ѿ��ɹ�������д�뱾��log�����ǲ�û�еȴ�����follower�Ƿ�ɹ�д�롣��������£�
         *          ���followerû�гɹ��������ݣ�����ʱleader�ֹҵ�������Ϣ�ᶪʧ��
         * acks=all�� ����ζ��leader��Ҫ�ȴ����б��ݶ��ɹ�д����־�����ֲ��Իᱣֻ֤Ҫ��һ�����ݴ��Ͳ��ᶪʧ���ݡ�������ǿ�ı�֤��
         */
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        //��Ϣȷ�ϳ�ʱ�����Դ���
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        //2.����������
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        //3.������Ϣ
        ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "lance");
        producer.send(record);
        producer.close();
    }
}
