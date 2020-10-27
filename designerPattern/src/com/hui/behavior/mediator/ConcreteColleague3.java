package com.hui.behavior.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:28
 * @Description: �����ͬ���࣬���кܶ�, ÿ��ͬ��ֻ֪���Լ�����Ϊ�������˽�����ͬ�������Ϊ(����)���������Ƕ������н��߶���
 */
public class ConcreteColleague3 extends Colleague {

    @Override
    public void receive() {
        System.out.println("colleague3 receive message.");
    }

    @Override
    public void send() {
        System.out.println("colleague3 send message.");
        //���н���ת��
        this.mediator.relay(this);
    }
}
