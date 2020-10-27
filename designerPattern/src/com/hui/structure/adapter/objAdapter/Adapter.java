package com.hui.structure.adapter.objAdapter;

/**
 * @description: 适配器(Adaper)角色：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 * @author: Lance
 * @create: 2020-07-21 11:42
 **/
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void newRequest1() {
        adaptee.oldRequest1();
    }

    @Override
    public void newRequest2() {
        adaptee.oldRequest2();
    }
}
