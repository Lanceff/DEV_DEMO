package com.hui.proxy;

/**
 * @description:��ʵ����
 * @author: Lance
 * @create: 2020-07-20 08:23
 **/
public class RealSubject implements Subject{

    @Override
    public void operation() {
        System.out.println("��ʵ������в���");
    }
}
