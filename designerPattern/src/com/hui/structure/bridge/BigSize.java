package com.hui.structure.bridge;

/**
 * @description: ��չ���󻯽�ɫ�����󻯽�ɫ�����࣬ʵ�ָ����е�ҵ�񷽷�����ͨ����Ϲ�ϵ����ʵ�ֻ���ɫ�е�ҵ�񷽷���
 * @author: Lance
 * @create: 2020-07-20 08:57
 **/
public class BigSize extends Size {

    BigSize(Color color) {
        super(color);
    }

    @Override
    void sizeDesc() {
        System.out.println("����һ��" + this.color.colorDesc() + "�Ĵ��ͱ���");
    }
}
