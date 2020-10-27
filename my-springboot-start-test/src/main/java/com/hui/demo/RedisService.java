package com.hui.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: Lance
 * @Date: 2020-10-26 16:10
 * @Description:
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setKey(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
}
