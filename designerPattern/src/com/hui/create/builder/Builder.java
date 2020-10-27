package com.hui.create.builder;

/**
 * @description: ����Ľ�����
 * @author: Lance
 * @create: 2020-07-24 10:56
 **/
public abstract class Builder {

    protected House house = new House();

    abstract void builderBaise();

    abstract void builderWall();

    abstract void builderRoofed();

    public House builder() {
        return house;
    }
}
