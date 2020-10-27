package com.hui.behavior.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:34
 * @Description: ���崦���߽�ɫ2
 * */
public class ConcreteHandlerTwo extends Handler {

    @Override
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("���崦����2�����������");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("û���˴��������");
            }
        }
    }
}
