package com.hui.create.builder;

/**
 * @description: ��Ʒ��--������Ķ���
 * @author: Lance
 * @create: 2020-07-24 10:54
 **/
public class House {
    // ��ػ�
    private String baise;
    // ��ǽ
    private String wall;
    // �Ƿ���
    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    @Override
    public String toString() {
        return "House{" +
                "baise='" + baise + '\'' +
                ", wall='" + wall + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }
}
