package com.hui.create.singleton;

/**
 * @description: ˫�ؼ����
 * @author: Lance
 * @create: 2020-07-16 11:28
 **/
public class Leader3 {
    private static Leader3 instance;

    private Leader3() {
    }

    public static Leader3 getInstance() {
        if (instance == null) {
            synchronized (Leader3.class) {
                //˫�ؼ��
                if (instance == null) {
                    instance = new Leader3();
                }
            }
        }
        return instance;
    }
}
