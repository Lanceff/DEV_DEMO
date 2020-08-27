package com.hui.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:15
 * @Description: 具体访问者角色A:实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么
 */
public class ComputerPartDisplayVisitorA implements ComputerPartVisitor {

    @Override
    public void visit(Mouse mouse) {
        System.out.println("我是鼠标.访问者A进行访问，A逻辑处理");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("我是键盘.访问者A进行访问，A逻辑处理");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("我是显示器.访问者A进行访问，A逻辑处理");
    }
}
