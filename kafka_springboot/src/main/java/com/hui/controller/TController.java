package com.hui.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Lance
 * @Date: 2020-07-31 11:35
 * @Description:
 */
@RestController
public class TController {

    @Autowired
    private KafkaTemplate template;


    @Transactional
    @RequestMapping("/send")
    public String sendMsg(String msg) {
        template.send(new ProducerRecord("topic1", msg + "1"));
        template.send(new ProducerRecord("topic1", msg + "2"));
        return "send " + msg + " success";
    }
}
