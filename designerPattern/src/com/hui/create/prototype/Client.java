package com.hui.create.prototype;

/**
 * @author: Lance
 * @Date: 2020-08-19 18:45
 * @Description: ԭ��ģʽ, ǳ����
 * 1) �������������ǻ����������͵ĳ�Ա������ǳ������ֱ�ӽ���ֵ���ݣ�Ҳ���ǽ�������ֵ����һ�ݸ��µĶ���
 * 2) �������������������������͵ĳ�Ա����������˵��Ա������ĳ�����顢ĳ����Ķ���ȣ���ôǳ���������
 * ���ô��ݣ�Ҳ����ֻ�ǽ��ó�Ա����������ֵ���ڴ��ַ������һ�ݸ��µĶ�����Ϊʵ������������ĸó�
 * Ա������ָ��ͬһ��ʵ��������������£���һ���������޸ĸó�Ա������Ӱ�쵽��һ������ĸó�Ա����ֵ
 *
 * ��� ʵ�ַ�ʽ
 * 1����д clone ������ʵ�����
 * 2��ͨ�� �������л�ʵ�����(�Ƽ�)
 */
public class Client {
    public static void main(String[] args) {

        Sheep sheep = new Sheep("tom", 1, "��ɫ");
        Friend friend = new Friend("Calan", 2, "��ɫ");
        sheep.setFriend(friend);

        Sheep sheep2 = sheep.clone(); //��¡
        Sheep sheep3 = sheep.clone(); //��¡
        Sheep sheep4 = sheep.clone(); //��¡
        Sheep sheep5 = sheep.clone(); //��¡

        //����ǳ����
        System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
        System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
        System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
        System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());
    }
}
