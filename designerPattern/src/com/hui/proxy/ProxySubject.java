package com.hui.proxy;

/**
 * @description:������
 * @author: Lance
 * @create: 2020-07-20 08:24
 **/
public class ProxySubject implements Subject {

    @Override
    public void operation() {
        //������ʵ����ʵ��
        RealSubject realSubject = new RealSubject();
        //������ʵ����ķ���
        realSubject.operation();
        //�������������Ĳ���
        System.out.println("������������Ĳ�������ǿ��ʵ��");
    }
}
