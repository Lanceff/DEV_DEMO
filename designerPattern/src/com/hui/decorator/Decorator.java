package com.hui.decorator;

/**
 * @description: 装饰角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
 * @author: Lance
 * @create: 2020-07-27 09:04
 **/
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void opreation() {
        //委派给构件
        component.opreation();
    }
}
