package com.hui.lifeCycle;

import com.hui.user.Color;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * bean的生命周期： bean创建---初始化----销毁的过程
 * 1）、指定初始化和销毁方法：通过@Bean指定init-method和destroy-method；
 * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），DisposableBean（定义销毁逻辑）;
 * 3）、可以使用JSR250；
 *       @PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
 *       @PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * 4）、BeanPostProcessor【interface】：bean的后置处理器；
 *        postProcessBeforeInitialization:在初始化之前工作
 *        postProcessAfterInitialization:在初始化之后工作
 *
 * 执行顺序
 * Lbean1 构造函数
 * lbean1 postProcessBeforeInitialization。。。
 * Lbean1 @PostConstruct...
 * Lbean1 InitializingBean -> afterPropertiesSet ...
 * Lbean1 method-init...
 * lbean1 postProcessAfterInitialization。。。
 * Lbean1 @PreDestroy...
 * Lbean1 DisposableBean -> destroy ...
 * Lbean1 method-destroy...
 *
 * */
@Configurable
@ComponentScan(value = "com.hui", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Repository.class, Service.class})
})
public class LifeCycleConfig {


    /**
     * 自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
     * 构造（对象创建）
     * 单实例：在容器启动的时候创建对象
     * 多实例：在每次获取的时候创建对象
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Color color() {
        return new Color();
    }

    @Bean(initMethod = "methodInit", destroyMethod = "methodDestroy")
    @Lazy(value = false)
    public Lbean1 lbean1() {
        return new Lbean1();
    }

}
