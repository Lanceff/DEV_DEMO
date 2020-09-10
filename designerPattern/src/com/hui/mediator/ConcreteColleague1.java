package com.hui.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:27
 * @Description: �����ͬ���࣬���кܶ�, ÿ��ͬ��ֻ֪���Լ�����Ϊ�������˽�����ͬ�������Ϊ(����)���������Ƕ������н��߶���
 */
public class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("colleague1 receive message.");
    }

    @Override
    public void send() {
        System.out.println("colleague1 send message.");
        //���н���ת��
        this.mediator.relay(this);
    }
}