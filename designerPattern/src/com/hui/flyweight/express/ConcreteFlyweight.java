package com.hui.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-09-10 08:45
 * @Description: ������Ԫ��
 */
public class ConcreteFlyweight implements Flyweight {

    ConcreteFlyweight() {
        System.out.println("������Ԫ��");
    }

    @Override
    public void operator() {
        System.out.println("������Ԫ��ִ�е�ҵ���߼�");
    }
}
