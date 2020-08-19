package com.hui.observer;

/**
 * @description:�۲���ģʽ
 * @author: Lance
 * @create: 2020-07-18 08:44
 **/
public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new ObserverA());
        subject.addObserver(new ObserverB());

        subject.changeStatus();
    }
}
