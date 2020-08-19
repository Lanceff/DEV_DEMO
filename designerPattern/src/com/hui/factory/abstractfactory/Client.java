package com.hui.factory.abstractfactory;

/**
 * @description:���󹤳�ģʽ��������Ʒ��
 * @author: Lance
 * @create: 2020-07-14 22:04
 **/
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new HpComputerFactory();
        factory.createMouse().useful();
        factory.createKeyBoard().useful();
    }
}
