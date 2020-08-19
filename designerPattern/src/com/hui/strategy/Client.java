package com.hui.strategy;

/**
 * @description:����ģʽ ��Ϊ��
 * ��ģʽ������һϵ���㷨������ÿ���㷨��װ������ʹ���ǿ����໥�滻�����㷨�ı仯����Ӱ��ʹ���㷨�Ŀͻ���
 * ����ģʽ���ڶ�����Ϊģʽ����ͨ�����㷨���з�װ����ʹ���㷨�����κ��㷨��ʵ�ַָ������ί�ɸ���ͬ�Ķ������Щ�㷨���й���
 * @author: Lance
 * @create: 2020-07-18 08:21
 **/
public class Client {
    public static void main(String[] args) {
        Context context1=new Context(new StrategyA());
        context1.operator();

        Context context2=new Context(new StrategyB());
        context2.operator();

        Context context3=new Context(new StrategyC());
        context3.operator();
    }
}
