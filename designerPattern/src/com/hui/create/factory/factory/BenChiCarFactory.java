package com.hui.create.factory.factory;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-14 11:30
 **/
public class BenChiCarFactory implements CarFactoryInter{

    @Override
    public Car createCar() {
        return new BenChiCar();
    }
}
