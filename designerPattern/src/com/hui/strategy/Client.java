package com.hui.strategy;

/**
 * @description:策略模式 行为型
 * 该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。
 * 策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。
 * @author: Lance
 * @create: 2020-07-18 08:21
 **/
public class Client {
    public static void main(String[] args) {
        Context context1=new Context(new StrategyA());
        context1.operator();

        Context context2=new Context(new StrategyB());
        context2.operator();

        Context context3=new Context(new StrategyC());
        context3.operator();
    }
}
