package com.hui.factory.factory;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-14 11:38
 **/
public class BwmCarFactory implements CarFactoryInter {
    @Override
    public Car createCar() {
        return new BwmCar();
    }
}
