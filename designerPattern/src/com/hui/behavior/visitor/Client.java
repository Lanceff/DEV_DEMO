package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:00
 * @Description: 访问者模式
 * 将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，
 * 为数据结构中的每个元素提供多种访问方式。它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式
 * 访问者模式的使用场景:
 * 1.对象结构比较稳定，但经常需要在此对象结构上定义新的操作。
 * 2.需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免这些操作“污染”这些对象的类，也不希望在增加新操作时修改这些类。
 */
public class Client {

    public static void main(String[] args) {
        //定义两个访问者，每个访问者访问时处理操作不一样
        ComputerPartVisitor visitorA = new ComputerPartDisplayVisitorA();
        ComputerPartVisitor visitorB = new ComputerPartDisplayVisitorB();

        //对象结构,存放所有要被访问元素，提供accept()方法接收具体的访问者
        Computer computer = new Computer();
        computer.add(new Monitor());
        computer.add(new Mouse());
        computer.add(new Keyboard());

        //对象
        computer.accept(visitorA);
        System.out.println("=========================");
        computer.accept(visitorB);
    }

}
