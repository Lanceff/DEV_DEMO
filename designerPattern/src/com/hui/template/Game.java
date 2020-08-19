package com.hui.template;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 10:17
 **/
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //ģ��
    final void play() {
        //��ʼ����Ϸ
        initialize();
        //��ʼ��Ϸ
        startPlay();
        //������Ϸ
        endPlay();
    }
}
