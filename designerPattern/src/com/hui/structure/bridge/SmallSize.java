package com.hui.structure.bridge;

/**
 * @description: ��չ���󻯽�ɫ�����󻯽�ɫ�����࣬ʵ�ָ����е�ҵ�񷽷�����ͨ����Ϲ�ϵ����ʵ�ֻ���ɫ�е�ҵ�񷽷���
 * @author: Lance
 * @create: 2020-07-20 09:06
 **/
public class SmallSize extends Size {


    SmallSize(Color color) {
        super(color);
    }

    @Override
    void sizeDesc() {
        System.out.println("����һ��" + this.color.colorDesc() + "��С�ͱ���");
    }
}
