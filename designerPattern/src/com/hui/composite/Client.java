package com.hui.composite;

/**
 * @author: Lance
 * @Date: 2020-08-15 09:55
 * @Description: 组合模式   机构型
 * 意图： 将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * 主要解决：它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以像处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
 * 何时使用： 1、您想表示对象的部分-整体层次结构（树形结构）。 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 * 如何解决：树枝和叶子实现统一接口，树枝内部组合该接口。
 */
public class Client {

    public static void main(String[] args) {
        Employee CEO = new Employee("董事长", "CEO", 50000);
        Employee leader1 = new Employee("-- 干部1", "head", 20000);
        Employee leader2 = new Employee("-- 干部2", "head", 20000);
        CEO.add(leader1);
        CEO.add(leader2);

        Employee emp1 = new Employee("---- 员工1", "emp", 10000);
        Employee emp2 = new Employee("---- 员工2", "emp", 10000);
        Employee emp3 = new Employee("---- 员工3", "emp", 10000);
        Employee emp4 = new Employee("---- 员工4", "emp", 10000);

        leader1.add(emp1);
        leader1.add(emp2);
        leader2.add(emp3);
        leader2.add(emp4);

        System.out.println(CEO);

        CEO.getSubordinates().stream().forEach(e->{
            System.out.println(e);
            e.getSubordinates().stream().forEach(System.out::println);
        });
    }
}
