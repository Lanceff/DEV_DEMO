package com.hui.builder;

/**
 * @description: ������ģʽ
 * @author: Lance
 * @create: 2020-07-24 10:54
 **/
public class Client {

    public static void main(String[] args) {
        System.out.println("==========��ʼ����ͨ����========");
        Director director = new Director(new CommonHouseBuilder());
        director.createHouser();
        System.out.println("==========��ͨ���Ӹ���==========");
        System.out.println();
        System.out.println("==========��ʼ�Ǹ߼�����========");
        director.setBuilder(new HighHouseBuilder());
        director.createHouser();
        System.out.println("==========�߼����Ӹ���==========");
    }
}
