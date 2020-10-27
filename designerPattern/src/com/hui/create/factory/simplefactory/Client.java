package com.hui.create.factory.simplefactory;

/**
 * @description:简单工厂模式 又叫做静态工厂方法模式。简单工厂模式的实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。
 * @author: Lance
 * @create: 2020-07-14 11:20
 **/
public class Client {
    public static void main(String[] args) {
        Car car1 = SimpleFactory.createCar("宝马");
        car1.driver();
    }
}
