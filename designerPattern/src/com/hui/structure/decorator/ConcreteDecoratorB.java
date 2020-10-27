package com.hui.structure.decorator;

/**
 * @description: 具体装饰角色：负责给构件对象“贴上”附加的责任
 * @author: Lance
 * @create: 2020-07-27 09:05
 **/
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void opreation() {
        super.opreation();
        //TODO 完成相关的业务代码
        System.out.println("附加业务B逻辑执行");
    }
}
