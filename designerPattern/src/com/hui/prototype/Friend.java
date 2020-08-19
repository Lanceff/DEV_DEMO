package com.hui.prototype;

/**
 * @author: Lance
 * @Date: 2020-08-19 19:21
 * @Description: ”√”⁄…ÓøΩ±¥≤‚ ‘
 */
public class Friend implements Cloneable{

    private String name;
    private int age;
    private String color;

    public Friend(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Friend clone() throws CloneNotSupportedException {
        return (Friend) super.clone();
    }
}
