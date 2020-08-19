package com.hui.factory.factory;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-14 11:39
 **/
public class Client {

    public static void main(String[] args) {
        CarFactoryInter factory = new BenChiCarFactory();
        factory.createCar().driver();

        CarFactoryInter factory1 = new BwmCarFactory();
        factory1.createCar().driver();

    }
}
