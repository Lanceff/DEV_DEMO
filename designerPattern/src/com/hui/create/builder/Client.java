package com.hui.create.builder;

/**
 * @description: 建造者模式
 * 角色：产品、抽象建造者、具体建造者、指挥者
 * 指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示
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
