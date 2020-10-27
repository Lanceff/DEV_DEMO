package com.hui.structure.adapter.objAdapter;

/**
 * @description: 适配者
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
