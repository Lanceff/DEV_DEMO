package com.hui.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:14
 * @Description: 具体元素类:鼠标
 * 实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}