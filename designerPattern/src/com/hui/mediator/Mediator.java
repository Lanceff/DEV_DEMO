package com.hui.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:26
 * @Description: 抽象中介者
 */
public abstract class Mediator {

    //注册同事
    abstract void register(Colleague colleague);

    //通知中介者，发送消息
    abstract void relay(Colleague colleague);

}
