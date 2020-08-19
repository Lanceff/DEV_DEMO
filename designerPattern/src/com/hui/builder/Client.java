package com.hui.builder;

/**
 * @description: 建造者模式
 * @author: Lance
 * @create: 2020-07-24 10:54
 **/
public class Client {

    public static void main(String[] args) {
        System.out.println("==========开始盖普通房子========");
        Director director = new Director(new CommonHouseBuilder());
        director.createHouser();
        System.out.println("==========普通房子盖完==========");
        System.out.println();
        System.out.println("==========开始盖高级房子========");
        director.setBuilder(new HighHouseBuilder());
        director.createHouser();
        System.out.println("==========高级房子盖完==========");
    }
}
