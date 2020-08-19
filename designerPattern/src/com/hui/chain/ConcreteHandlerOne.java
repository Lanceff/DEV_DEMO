package com.hui.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:34
 * @Description: ���崦���߽�ɫ1,ʵ�ֳ������ߵĴ��������ж��ܷ���������������Դ��������������򽫸�����ת�����ĺ���ߡ�
 */
public class ConcreteHandlerOne extends Handler{

    @Override
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("���崦����1�����������");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("û���˴��������");
            }
        }
    }
}
