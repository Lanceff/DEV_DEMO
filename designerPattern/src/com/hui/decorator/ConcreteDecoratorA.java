package com.hui.decorator;

/**
 * @description: ����װ�ν�ɫ������������������ϡ����ӵ�����
 * @author: Lance
 * @create: 2020-07-27 09:05
 **/
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void opreation() {
        super.opreation();
        //TODO �����ص�ҵ�����
        System.out.println("����ҵ��A�߼�ִ��");
    }
}
