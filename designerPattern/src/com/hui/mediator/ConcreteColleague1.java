package com.hui.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:27
 * @Description: 具体的同事类，会有很多, 每个同事只知道自己的行为，而不了解其他同事类的行为(方法)，但是他们都依赖中介者对象
 */
public class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("colleague1 receive message.");
    }

    @Override
    public void send() {
        System.out.println("colleague1 send message.");
        //请中介者转发
        this.mediator.relay(this);
    }
}