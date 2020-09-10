package com.hui.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description: �������Ԫ��ɫ���Ǿ���Ĳ�Ʒ�࣬ʵ�ֳ����ɫ�������ҵ��
 */
public class ConcreteWebSite implements WebSite{

    //����Ĳ��֣��ڲ�״̬
    private String type = ""; //��վ��������ʽ(����)
    //������
    public ConcreteWebSite(String type) {
        this.type = type;
    }
    @Override
    public void use(OutsideUser user) {
        System.out.println("��վ�ķ�����ʽΪ:" + type + " ��ʹ���� .. ʹ������" + user.getName());
    }
}
