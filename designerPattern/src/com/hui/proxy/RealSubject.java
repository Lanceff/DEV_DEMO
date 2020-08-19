package com.hui.proxy;

/**
 * @description:真实对象
 * @author: Lance
 * @create: 2020-07-20 08:23
 **/
public class RealSubject implements Subject{

    @Override
    public void operation() {
        System.out.println("真实对象进行操作");
    }
}
