package com.hui.behavior.template;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 10:56
 **/
public class ChijiGame extends Game {
    @Override
    void initialize() {
        System.out.println("��װ��ƽ��Ӣ");
    }

    @Override
    void startPlay() {
        System.out.println("��ʼ���ƽ��ӢӴ���Լ���");
    }

    @Override
    void endPlay() {
        System.out.println("�������ƽ��Ӣ");
    }
}
