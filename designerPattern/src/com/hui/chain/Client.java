package com.hui.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:26
 * @Description: ������ģʽ��Ϊ�˱����������������������������һ�𣬽���������Ĵ�����ͨ��ǰһ�����ס����һ����������ö�����һ������
 * ����������ʱ���ɽ������������������ݣ�ֱ���ж�������Ϊֹ��
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandlerOne();
        Handler handler2 = new ConcreteHandlerTwo();
        handler1.setNext(handler2);
        handler1.handleRequest("two");
    }
}
