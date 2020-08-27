package com.hui.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: Lance
 * @Date: 2020-08-27 18:25
 * @Description:
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.hui.aop")
public class AopConfig {

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

}
