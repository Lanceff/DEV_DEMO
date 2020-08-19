package transactions;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author Lance
 * @Date: 2020-07-30 09:24
 * @Description: ������only ������
 */
public class TransactionProducer {

    public static void main(String[] args) {
        //1.����Kafka���Ӳ���
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //����idΨһ��
        config.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "transaction_id");
        //2.����������
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(config);

        //��ʼ������
        producer.initTransactions();

        try {
            //��������
            producer.beginTransaction();
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(2000);
                //����
                if (i == 8) {
                    int temp = 1 / 0;
                }
                ProducerRecord<String, String> record = new ProducerRecord<>("topic03", "key" + i, "hello word,lance" + i);
                producer.send(record);
            }
            //�ύ����
            producer.commitTransaction();
        } catch (Exception e) {
            System.err.println(e.toString());
            //��ֹ�����൱�ڻع�
            producer.abortTransaction();
        } finally {
            producer.close();
        }
    }
}
