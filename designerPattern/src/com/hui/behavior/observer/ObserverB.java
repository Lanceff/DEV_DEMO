package com.hui.behavior.observer;

/**
 * @description:具体观察者
 * @author: Lance
 * @create: 2020-07-18 08:51
 **/
public class ObserverB implements Observer{

    @Override
    public void update() {
        System.out.println("观察者B接收到消息后跑去操场集合");
    }
}
