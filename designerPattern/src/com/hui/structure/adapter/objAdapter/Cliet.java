package com.hui.structure.adapter.objAdapter;

/**
 * @description: ������ģʽ��������������
 * Target��Ŀ�������
 * Adapter����������
 * Adaptee����������
 * Client���ͻ���
 * @author: Lance
 * @create: 2020-07-21 11:19
 **/
public class Cliet {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.newRequest1();
        target.newRequest2();
    }

}
