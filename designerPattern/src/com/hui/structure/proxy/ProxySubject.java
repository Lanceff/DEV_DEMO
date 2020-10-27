package com.hui.structure.proxy;

/**
 * @description:代理类
 * 提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能
 * @author: Lance
 * @create: 2020-07-20 08:24
 **/
public class ProxySubject implements Subject {

    @Override
    public void operation() {
        //创建真实对象实例
        RealSubject realSubject = new RealSubject();
        //调用真实对象的方法
        realSubject.operation();
        //代理对象额外做的操作
        System.out.println("代理类做额外的操作，增强真实类");
    }
}
