package com.hui.create.builder;

/**
 * @description: ���彨����A
 * @author: Lance
 * @create: 2020-07-24 15:20
 **/
public class CommonHouseBuilder extends Builder {

    @Override
    public void builderBaise() {
        house.setBaise("��ͨ���Ӵ�ػ�");
        System.out.println("��ͨ���Ӵ�ػ�");
    }

    @Override
    public void builderWall() {
        house.setWall("��ͨ������ǽ");
        System.out.println("��ͨ������ǽ");
    }

    @Override
    public void builderRoofed() {
        house.setWall("��ͨ���ӷⶥ");
        System.out.println("��ͨ���ӷⶥ");
    }
}
