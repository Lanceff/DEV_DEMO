package com.hui.structure.bridge;

/**
 * @description: �Ž�ģʽ����ά�ȱ仯���������󲿷�������ʵ�ֲ��ַ��뿪����ʹ���Ƕ����Զ����仯��
 * �Ž�ģʽͨ�����������³�����
 * 1.��һ����������������仯��ά�ȣ���������ά�ȶ���Ҫ������չʱ��
 * 2.��һ��ϵͳ��ϣ��ʹ�ü̳л���Ϊ���μ̳е���ϵͳ��ĸ�����������ʱ��
 * 3.��һ��ϵͳ��Ҫ�ڹ����ĳ��󻯽�ɫ�;��廯��ɫ֮�����Ӹ���������ʱ��
 * @author: Lance
 * @create: 2020-07-20 08:55
 **/
public class Client {
    public static void main(String[] args) {
        BigSize c1 = new BigSize(new RedColor());
        c1.sizeDesc();
        SmallSize c2 = new SmallSize(new RedColor());
        c2.sizeDesc();

        BigSize c3 = new BigSize(new BlackColor());
        c3.sizeDesc();
        SmallSize c4 = new SmallSize(new BlackColor());
        c4.sizeDesc();

    }
}
