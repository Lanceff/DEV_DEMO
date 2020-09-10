package com.hui.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description: UnSharedConcreteFlyWeight 是不可共享的角色，一般不会出现在享元工厂
 */
public class OutsideUser {

    public OutsideUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
