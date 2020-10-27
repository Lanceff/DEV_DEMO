package com.hui.structure.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-09-10 08:45
 * @Description: 具体享元角色：实现抽象享元角色中所规定的接口。
 */
public class ConcreteFlyweight implements Flyweight {

    private String key;

    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("创建享元类" + key);
    }

    @Override
    public void operator() {
        System.out.println("具体享元类" + key + "执行的业务逻辑");
    }

    @Override
    public void operator1(UnsharableFlyweight unsharableFlyweight) {
        System.out.println("具体享元类" + key + "执行的业务逻辑operator1");
        System.out.println("非享元类" + key + "执行的业务逻辑getInfo=" + unsharableFlyweight.getInfo());
    }


}
