package com.hui.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:26
 * @Description: �����н���
 */
public abstract class Mediator {

    //ע��ͬ��
    abstract void register(Colleague colleague);

    //֪ͨ�н��ߣ�������Ϣ
    abstract void relay(Colleague colleague);

}
