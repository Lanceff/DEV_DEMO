package com.hui.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description: UnSharedConcreteFlyWeight �ǲ��ɹ���Ľ�ɫ��һ�㲻���������Ԫ����
 */
public class OutsideUser {

    public OutsideUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
