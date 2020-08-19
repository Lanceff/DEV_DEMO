package com.hui.template;

/**
 * @description:模板方法模型 是一种行为设计模型。模板方法是一个定义在父类别的方法，在模板方法中会呼叫多个定义在父类别的其他方法，
 * 而这些方法有可能只是抽象方法并没有实作，模板方法仅决定这些抽象方法的执行顺序，这些抽象方法的实作由子类别负责，并且子类别不允许覆写模板方法。
 * @author: Lance
 * @create: 2020-07-16 10:57
 **/
public class Client {

    public static void main(String[] args) {
        Game wangzhe = new WangzheGame();
        wangzhe.play();
        System.out.println("===========休息10分钟============");
        Game chiji = new ChijiGame();
        chiji.play();
    }
}
