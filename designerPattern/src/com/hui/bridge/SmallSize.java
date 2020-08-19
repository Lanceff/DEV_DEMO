package com.hui.bridge;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-20 09:06
 **/
public class SmallSize extends Size {


    SmallSize(Color color) {
        super(color);
    }

    @Override
    void sizeDesc() {
        System.out.println("创建一个" + this.color.colorDesc() + "的小型杯子");
    }
}
