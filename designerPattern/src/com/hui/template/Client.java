package com.hui.template;

/**
 * @description:ģ�巽��ģ�� ��һ����Ϊ���ģ�͡�ģ�巽����һ�������ڸ����ķ�������ģ�巽���л���ж�������ڸ���������������
 * ����Щ�����п���ֻ�ǳ��󷽷���û��ʵ����ģ�巽����������Щ���󷽷���ִ��˳����Щ���󷽷���ʵ����������𣬲������������дģ�巽����
 * @author: Lance
 * @create: 2020-07-16 10:57
 **/
public class Client {

    public static void main(String[] args) {
        Game wangzhe = new WangzheGame();
        wangzhe.play();
        System.out.println("===========��Ϣ10����============");
        Game chiji = new ChijiGame();
        chiji.play();
    }
}
