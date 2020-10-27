package com.hui.create.builder;

/**
 * @description: 具体建造者A
 * @author: Lance
 * @create: 2020-07-24 15:20
 **/
public class CommonHouseBuilder extends Builder {

    @Override
    public void builderBaise() {
        house.setBaise("普通房子打地基");
        System.out.println("普通房子打地基");
    }

    @Override
    public void builderWall() {
        house.setWall("普通房子砌墙");
        System.out.println("普通房子砌墙");
    }

    @Override
    public void builderRoofed() {
        house.setWall("普通房子封顶");
        System.out.println("普通房子封顶");
    }
}
