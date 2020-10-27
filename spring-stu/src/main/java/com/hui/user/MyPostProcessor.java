package com.hui.user;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: Lance
 * @Date: 2020-08-27 11:25
 * @Description: 后置处理器
 */
@Component
public class MyPostProcessor implements BeanPostProcessor {

    /**
     * postProcessBeforeInitialization:在初始化之前工作
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+" postProcessBeforeInitialization。。。");
        return bean;
    }

    /**
     * postProcessAfterInitialization:在初始化之后工作
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+" postProcessAfterInitialization。。。");
        return bean;
    }
}
