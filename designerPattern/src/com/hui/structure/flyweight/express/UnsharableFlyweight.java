package com.hui.structure.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-10-13 08:33
 * @Description: ����Ԫ��ɫ���ǲ����Թ�����ⲿ״̬�����Բ�������ʽע�������Ԫ����ط�����
 */
public class UnsharableFlyweight {
    private String info;

    UnsharableFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
