package com.hui.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:���۲���
 * @author: Lance
 * @create: 2020-07-18 08:46
 **/
public class Subject {

    List<Observer> observers = new ArrayList<>();

    //��ӡ�ע��۲���
    void addObserver(Observer observer){
        observers.add(observer);
    }
    //�Ƴ��۲���
    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    //���۲���״̬�ı䣬֪ͨ���й۲���,�۲�������Ӧ����
    void changeStatus() {
        observers.forEach((observer)->{
            observer.update();
        });
    }

}
