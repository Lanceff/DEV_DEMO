package com.hui.builder;

/**
 * @description: 抽象的建造者
 * @author: Lance
 * @create: 2020-07-24 10:56
 **/
public interface Builder {

    void builderBaise();

    void builderWall();

    void builderRoofed();

    House builder();
}
