package com.hui.structure.proxy;

/**
 * @description:����ģʽ
 * @author: Lance
 * @create: 2020-07-20 08:16
 **/
public class Client {

    public static void main(String[] args) {
        ProxySubject proxy = new ProxySubject();
        proxy.operation();
    }
}
