package com.hui.structure.bridge;

/**
 * @description: ���󻯽�ɫ����������࣬������һ����ʵ�ֻ����������
 * @author: Lance
 * @create: 2020-07-20 08:56
 **/
public abstract class Size {
    protected Color color;

    protected Size(Color color) {
        this.color = color;
    }

    abstract void sizeDesc();
}