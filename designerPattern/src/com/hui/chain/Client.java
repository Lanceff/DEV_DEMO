package com.hui.chain;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:26
 * @Description: 责任链模式：为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandlerOne();
        Handler handler2 = new ConcreteHandlerTwo();
        handler1.setNext(handler2);
        handler1.handleRequest("two");
    }
}
