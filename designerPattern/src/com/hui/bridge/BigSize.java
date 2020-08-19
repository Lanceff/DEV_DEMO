package com.hui.bridge;

/**
 * @description: 桥接模式
 * @author: Lance
 * @create: 2020-07-20 08:57
 **/
public class BigSize extends Size {

    BigSize(Color color) {
        super(color);
    }

    @Override
    void sizeDesc() {
        System.out.println("创建一个" + this.color.colorDesc() + "的大型杯子");
    }
}
