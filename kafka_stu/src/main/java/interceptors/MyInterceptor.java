package interceptors;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-28 15:25
 **/
public class MyInterceptor implements ProducerInterceptor<String, String> {
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        ProducerRecord wrapRecord = new ProducerRecord(producerRecord.topic(), producerRecord.key(), producerRecord.value() + ">>>LANCE");
        return wrapRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        System.out.println("metadata:" + recordMetadata + ",exception:" + e);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
