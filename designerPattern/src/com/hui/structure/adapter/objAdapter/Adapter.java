package com.hui.structure.adapter.objAdapter;

/**
 * @description: ������(Adaper)��ɫ�����������Ǳ�ģʽ�ĺ��ġ���������Դ�ӿ�ת����Ŀ��ӿڡ���Ȼ����һ��ɫ�������ǽӿڣ��������Ǿ����ࡣ
 * @author: Lance
 * @create: 2020-07-21 11:42
 **/
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void newRequest1() {
        adaptee.oldRequest1();
    }

    @Override
    public void newRequest2() {
        adaptee.oldRequest2();
    }
}
