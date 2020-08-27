package com.hui.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:15
 * @Description: 抽象访问者角色:定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
 */
public interface ComputerPartVisitor {

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

}
