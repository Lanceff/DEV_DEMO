package com.hui.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:被观察者
 * @author: Lance
 * @create: 2020-07-18 08:46
 **/
public class Subject {

    List<Observer> observers = new ArrayList<>();

    //添加、注册观察者
    void addObserver(Observer observer){
        observers.add(observer);
    }
    //移除观察者
    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    //被观察者状态改变，通知所有观察者,观察者做相应操作
    void changeStatus() {
        observers.forEach((observer)->{
            observer.update();
        });
    }

}
