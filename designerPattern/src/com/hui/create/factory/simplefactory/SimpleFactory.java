package com.hui.create.factory.simplefactory;

/**
 * @program: springcloud
 * @description:
 * @author: Lance
 * @create: 2020-07-14 11:17
 **/
public class SimpleFactory {

    public final static String BC_CAR = "����";
    public final static String BWN_CAR = "����";

    static Car createCar(String name) {
        if (BC_CAR.equalsIgnoreCase(name)) {
            return new BenChiCar();
        } else if (BWN_CAR.equalsIgnoreCase(name)) {
            return new BwmCar();
        } else {
            System.out.println("�޷�����" + name);
            return null;
        }
    }
}
