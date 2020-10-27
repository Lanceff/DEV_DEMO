package com.hui.structure.decorator;

/**
 * @description: 具体构件角色：定义一个将要接收附加责任的类
 * @author: Lance
 * @create: 2020-07-27 09:02
 **/
public class ConcreteComponent  implements  Component{

    @Override
    public void opreation() {
        System.out.println("原有业务执行");
    }
}
