package com.hui.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:27
 * @Description: 抽象处理者角色,定义一个处理请求的接口，包含抽象处理方法和一个后继连接
 */
public abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    //处理请求的方法
    public abstract void handleRequest(String request);
}
