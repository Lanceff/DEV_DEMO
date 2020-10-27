package com.hui.create.singleton;

/**
 * @description: ����ʽ,�̰߳�ȫ
 * @author: Lance
 * @create: 2020-07-16 11:05
 **/
public class Leader1 {

    private static final Leader1 instance = new Leader1();

    private Leader1() {
    }

    public static Leader1 getInstance() {
        return instance;
    }
}
