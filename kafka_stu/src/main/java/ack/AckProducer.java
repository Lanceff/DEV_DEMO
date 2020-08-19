package ack;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @description: ack机制，可能导致生产者数据重复发送
 * @author: Lance
 * @create: 2020-07-29 14:17
 **/
public class AckProducer {

    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //生产者发送消息到kafka后，确认发送成功的超时时间，设置1ms便于测试生产者重复发送消息的场景
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1);
        /**
         * producer需要server接收到数据之后发出的确认接收的信号，此项配置就是指procuder需要多少个这样的确认信号。此配置实际上代表了数据备份的可用性。以下设置为常用选项：
         * acks=0： 设置为0表示producer不需要等待任何确认收到的信息。副本将立即加到socket  buffer并认为已经发送。
         *          没有任何保障可以保证此种情况下server已经成功接收数据，同时重试配置不会发生作用（因为客户端不知道是否失败）回馈的offset会总是设置为-1；
         * acks=1： 这意味着至少要等待leader已经成功将数据写入本地log，但是并没有等待所有follower是否成功写入。这种情况下，
         *          如果follower没有成功备份数据，而此时leader又挂掉，则消息会丢失。
         * acks=all： 这意味着leader需要等待所有备份都成功写入日志，这种策略会保证只要有一个备份存活就不会丢失数据。这是最强的保证。
         */
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        //消息确认超时后重试次数
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        //2.创建生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        //3.发送消息
        ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "lance");
        producer.send(record);
        producer.close();
    }
}
