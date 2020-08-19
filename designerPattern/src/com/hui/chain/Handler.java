package com.hui.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:27
 * @Description: �������߽�ɫ,����һ����������Ľӿڣ���������������һ���������
 */
public abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    //��������ķ���
    public abstract void handleRequest(String request);
}
