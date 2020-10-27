package com.hui.structure.adapter.objAdapter;

/**
 * @description: 适配器模式：对象适配器法
 * Target：目标抽象类
 * Adapter：适配器类
 * Adaptee：适配者类
 * Client：客户类
 * @author: Lance
 * @create: 2020-07-21 11:19
 **/
public class Cliet {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.newRequest1();
        target.newRequest2();
    }

}
