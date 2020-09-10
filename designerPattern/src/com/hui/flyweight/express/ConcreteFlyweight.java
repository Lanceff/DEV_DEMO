package com.hui.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-09-10 08:45
 * @Description: 具体享元类
 */
public class ConcreteFlyweight implements Flyweight {

    ConcreteFlyweight() {
        System.out.println("创建享元类");
    }

    @Override
    public void operator() {
        System.out.println("具体享元类执行的业务逻辑");
    }
}
