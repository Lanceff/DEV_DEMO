package com.hui;

import io.lettuce.core.RedisClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * @author: Lance
 * @Date: 2020-10-26 15:03
 * @Description:
 */
@Configuration
@ConditionalOnClass(RedisClient.class)
public class RedisConfiguration {

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration(MyRedisProperties myRedisProperties,RedisPassword redisPassword){
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(myRedisProperties.getHost());
        standaloneConfiguration.setPort(myRedisProperties.getPort());
        standaloneConfiguration.setPassword(redisPassword);
        return standaloneConfiguration;
    }

    @Bean
    public RedisPassword redisPassword(MyRedisProperties myRedisProperties) {
        return RedisPassword.of(myRedisProperties.getPassword());
    }
}
