package com.hui.adapter.defaultAdapter;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-21 14:10
 **/
public class Server extends DefaultAdapter {

    @Override
    public void newRequest1() {
        System.out.println("调用重写的方法newRequest1");
    }

}
