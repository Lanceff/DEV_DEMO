package com.hui.structure.adapter.classAdapter;

/**
 * @description: 现在需要适配的接口,老版本接口
 * @author: Lance
 * @create: 2020-07-21 11:40
 **/
public class Adaptee {

    void oldRequest1() {
        System.out.println("发起调用老版本请求函数1");
    }

    void oldRequest2() {
        System.out.println("发起调用老版本请求函数2");
    }
}
