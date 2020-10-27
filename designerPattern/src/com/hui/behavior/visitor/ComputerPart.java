package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:08
 * @Description: 抽象元素类:声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
 */
public interface ComputerPart  {

    void accept(ComputerPartVisitor computerPartVisitor);
}
