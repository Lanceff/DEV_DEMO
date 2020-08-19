package com.hui.builder;

/**
 * @description: 具体建造者B
 * @author: Lance
 * @create: 2020-07-24 15:22
 **/
public class HighHouseBuilder implements Builder {

    private House house = new House();

    @Override
    public void builderBaise() {
        house.setBaise("高级房子打地基");
        System.out.println("高级房子打地基");
    }

    @Override
    public void builderWall() {
        house.setWall("高级房子砌墙");
        System.out.println("高级房子砌墙");
    }

    @Override
    public void builderRoofed() {
        house.setWall("高级房子封顶");
        System.out.println("高级房子封顶");
    }

    @Override
    public House builder() {
        return house;
    }
}
