package com.hui.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: Lance
 * @Date: 2020-08-27 10:34
 * @Description:
 */
public class Lbean1 implements InitializingBean, DisposableBean {
    public Lbean1() {
        System.out.println("Lbean1 构造");
    }

    @Override
    public void destroy() {
        System.out.println("Lbean1 DisposableBean=》 destroy ...");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Lbean1 InitializingBean =》afterPropertiesSet ...");
    }

    public void methodInit() {
        System.out.println("Lbean1 method-init...");
    }

    public void methodDestroy() {
        System.out.println("Lbean1 method-destroy...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Lbean1 @PostConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Lbean1 @PreDestroy...");
    }
}
