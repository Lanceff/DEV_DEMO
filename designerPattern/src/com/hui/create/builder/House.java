package com.hui.create.builder;

/**
 * @description: 产品类--被建造的对象
 * @author: Lance
 * @create: 2020-07-24 10:54
 **/
public class House {
    // 打地基
    private String baise;
    // 砌墙
    private String wall;
    // 盖房顶
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
