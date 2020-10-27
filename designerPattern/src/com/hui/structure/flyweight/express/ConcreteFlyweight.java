package com.hui.structure.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-09-10 08:45
 * @Description: ������Ԫ��ɫ��ʵ�ֳ�����Ԫ��ɫ�����涨�Ľӿڡ�
 */
public class ConcreteFlyweight implements Flyweight {

    private String key;

    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("������Ԫ��" + key);
    }

    @Override
    public void operator() {
        System.out.println("������Ԫ��" + key + "ִ�е�ҵ���߼�");
    }

    @Override
    public void operator1(UnsharableFlyweight unsharableFlyweight) {
        System.out.println("������Ԫ��" + key + "ִ�е�ҵ���߼�operator1");
        System.out.println("����Ԫ��" + key + "ִ�е�ҵ���߼�getInfo=" + unsharableFlyweight.getInfo());
    }


}
