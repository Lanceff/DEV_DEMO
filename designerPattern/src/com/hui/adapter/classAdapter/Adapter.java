package com.hui.adapter.classAdapter;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-21 11:49
 **/
public class Adapter extends Adaptee implements Target {

    @Override
    public void newRequest1() {
        oldRequest1();
    }

    @Override
    public void newRequest2() {
        oldRequest1();
    }
}
