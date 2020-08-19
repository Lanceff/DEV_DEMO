package com.hui.singleton;

/**
 * @description: 懒汉式，线程不安全
 * @author: Lance
 * @create: 2020-07-16 11:19
 **/
public class Leader2 {
    private static Leader2 instance;

    private Leader2() {
    }

    public static Leader2 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Leader2();
        }
        return instance;
    }
}
