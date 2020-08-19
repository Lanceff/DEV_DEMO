package idempotent;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @description: 幂等性，保证数据只发送一次，生产者写入的数据携带PID,Seq，在写入之前会比较kafka对应PID的CurrentSeq，
 * 如果seq>CurrentSeq,则成功写入，CurrentSeq更新；如果不满足，说明是重复数据，不进行写入
 * @author: Lance
 * @create: 2020-07-29 15:34
 **/
public class IdempotentProducer {
    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //生产者发送消息到kafka后，确认发送成功的超时时间，设置1ms便于测试生产者重复发送消息的场景
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1);

        /**
         * kafka开启幂等写，保证不重复写入
         * 幂等性必须配置 max.in.flight.requests.per.connection小于或等于5，retries大于0,acks必须为all(-1)，如果用户未明确设置这些值，则将选择合适的值
         */
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        //限制客户端在单个连接上能够发送的未响应请求的个数。设置此值是1表示kafka broker在响应请求之前client不能再向同一个broker发送请求。设置此参数是为了避免消息乱序
        config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        //消息确认超时后重试次数,确保数据不丢失
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        config.put(ProducerConfig.ACKS_CONFIG, "all");

        //2.创建生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        //3.发送消息
        ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "lance");
        producer.send(record);
        producer.close();
    }

}
