package com.hui.behavior.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:26
 * @Description: 抽象同事类
 */
public abstract class Colleague {

    //中介者抽象类
    protected Mediator mediator;

    //接受消息
    public abstract void receive();

    //发送消息
    public abstract void send();

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
