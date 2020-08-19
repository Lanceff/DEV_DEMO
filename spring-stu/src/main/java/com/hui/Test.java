package com.hui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Lance
 * @Date: 2020-08-15 19:04
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) ac.getBean("userService");
        System.out.println(userService);
    }
}
