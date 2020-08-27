package com.hui.lifeCycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: Lance
 * @Date: 2020-08-27 11:01
 * @Description:
 */
@Component
public class LBean2 {

    public LBean2() {
        System.out.println("LBean2 构造");
    }

    /**
     * 在bean创建完成并且属性赋值完成；来执行初始化方法
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("LBean2 @PostConstruct...");
    }

    /**
     * 在容器销毁bean之前通知我们进行清理工作
     */
    @PreDestroy
    public void PreDestroy() {
        System.out.println("LBean2 @PreDestroy...");
    }
}
