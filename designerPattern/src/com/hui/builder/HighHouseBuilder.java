package com.hui.builder;

/**
 * @description: ���彨����B
 * @author: Lance
 * @create: 2020-07-24 15:22
 **/
public class HighHouseBuilder implements Builder {

    private House house = new House();

    @Override
    public void builderBaise() {
        house.setBaise("�߼����Ӵ�ػ�");
        System.out.println("�߼����Ӵ�ػ�");
    }

    @Override
    public void builderWall() {
        house.setWall("�߼�������ǽ");
        System.out.println("�߼�������ǽ");
    }

    @Override
    public void builderRoofed() {
        house.setWall("�߼����ӷⶥ");
        System.out.println("�߼����ӷⶥ");
    }

    @Override
    public House builder() {
        return house;
    }
}
