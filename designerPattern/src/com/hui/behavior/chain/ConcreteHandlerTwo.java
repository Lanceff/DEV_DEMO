package com.hui.behavior.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:34
 * @Description: 具体处理者角色2
 * */
public class ConcreteHandlerTwo extends Handler {

    @Override
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("具体处理者2负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
