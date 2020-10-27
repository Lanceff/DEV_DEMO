package com.hui.structure.bridge;

/**
 * @description: 扩展抽象化角色：抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
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
