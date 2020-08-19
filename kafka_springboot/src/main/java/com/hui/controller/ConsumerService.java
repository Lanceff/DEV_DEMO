package com.hui.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author: Lance
 * @Date: 2020-07-31 14:16
 * @Description: @Component必须得要
 */
@Component
public class ConsumerService {

    @KafkaListener(topics = "topic1") //监听消息，有就立即消费
    @SendTo(value = {"topic2"})
    public String onMessage(ConsumerRecord<Object, String> consumerRecord) {
        System.out.println("topic1消费时间：" + System.currentTimeMillis() + "  " + consumerRecord.value());
        return consumerRecord.value() + " redirect to topic2";
    }

    @KafkaListener(topics = "topic2")
    public void onMessage2(ConsumerRecord<Object, String> consumerRecord) {
        System.out.println("topic2消费时间：" + System.currentTimeMillis() + "  " + consumerRecord.value());
    }

}
