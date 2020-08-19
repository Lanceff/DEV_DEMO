package com.hui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description:
 * @author: Lance
 * @create: 2020-07-09 11:28
 **/
@RestController
public class controller {

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/redis")
    public String getObj() {
        redisTemplate.opsForValue().set("name", "lance");
        return (String) redisTemplate.opsForValue().get("name");
    }

    @GetMapping("/pub")
    public String publish(String message) {
        redisTemplate.convertAndSend("ooxx", message);
        return "success";
    }

    @GetMapping("/sub")
    public void sub() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                byte[] body = message.getBody();
                System.out.println(new String(body));
            }
        },"ooxx".getBytes());

        while (true){

        }

    }
}
