package com.hui.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:14
 * @Description: 对象结构类
 * 是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 */
public class Computer {

    private List<ComputerPart> list;

    public Computer() {
        list = new ArrayList();
    }

    public void accept(ComputerPartVisitor computerPartvisitor) {
        list.stream().forEach(element -> {
            element.accept(computerPartvisitor);
        });
    }

    public void add(ComputerPart element) {
        list.add(element);
    }

    public void remove(ComputerPart element) {
        list.remove(element);
    }

}
