package com.hui.behavior.template;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 10:53
 **/
public class WangzheGame extends Game{

    @Override
    void initialize() {
        System.out.println("��װ������ҫ");
    }

    @Override
    void startPlay() {
        System.out.println("��ʼ��������ҫӴ��ʤ��");
    }

    @Override
    void endPlay() {
        System.out.println("������������ҫ");
    }
}
