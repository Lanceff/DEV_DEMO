package com.hui.create.factory.simplefactory;

/**
 * @description:�򵥹���ģʽ �ֽ�����̬��������ģʽ���򵥹���ģʽ��ʵ������һ����������ݴ���Ĳ�������̬����Ӧ�ô�����һ����Ʒ�ࣨ��Щ��Ʒ��̳���һ�������ӿڣ���ʵ����
 * @author: Lance
 * @create: 2020-07-14 11:20
 **/
public class Client {
    public static void main(String[] args) {
        Car car1 = SimpleFactory.createCar("����");
        car1.driver();
    }
}
