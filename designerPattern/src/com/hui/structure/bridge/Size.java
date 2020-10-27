package com.hui.structure.bridge;

/**
 * @description: 抽象化角色：定义抽象类，并包含一个对实现化对象的引用
 * @author: Lance
 * @create: 2020-07-20 08:56
 **/
public abstract class Size {
    protected Color color;

    protected Size(Color color) {
        this.color = color;
    }

    abstract void sizeDesc();
}
