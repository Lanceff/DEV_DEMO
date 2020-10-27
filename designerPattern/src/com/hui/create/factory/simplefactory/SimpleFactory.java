package com.hui.create.factory.simplefactory;

/**
 * @program: springcloud
 * @description:
 * @author: Lance
 * @create: 2020-07-14 11:17
 **/
public class SimpleFactory {

    public final static String BC_CAR = "奔驰";
    public final static String BWN_CAR = "宝马";

    static Car createCar(String name) {
        if (BC_CAR.equalsIgnoreCase(name)) {
            return new BenChiCar();
        } else if (BWN_CAR.equalsIgnoreCase(name)) {
            return new BwmCar();
        } else {
            System.out.println("无法制作" + name);
            return null;
        }
    }
}
