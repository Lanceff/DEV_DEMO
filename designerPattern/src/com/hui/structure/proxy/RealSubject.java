package com.hui.structure.proxy;

/**
 * @description: 真实主题
 * 实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象
 * @author: Lance
 * @create: 2020-07-20 08:23
 **/
public class RealSubject implements Subject{

    @Override
    public void operation() {
        System.out.println("真实对象进行操作");
    }
}
