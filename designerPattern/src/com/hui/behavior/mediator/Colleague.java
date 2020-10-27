package com.hui.behavior.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:26
 * @Description: ����ͬ����
 */
public abstract class Colleague {

    //�н��߳�����
    protected Mediator mediator;

    //������Ϣ
    public abstract void receive();

    //������Ϣ
    public abstract void send();

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
