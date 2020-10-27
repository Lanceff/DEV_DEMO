package com.hui.create.prototype;

/**
 * @author: Lance
 * @Date: 2020-08-19 18:39
 * @Description:
 */
public class Sheep implements Cloneable {

    private String name;
    private int age;
    private String color;

    //��֤�������
    public Friend friend;

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Sheep(String name, int age, String color) {
        super();
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
    public String toString() {
        return "Sheep [name=" + name + ", age=" + age + ", color=" + color + "]";
    }

   /*
    //��������ǳ����
    @Override
    protected Sheep clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }*/

    //�����������
    @Override
    protected Sheep clone() {
        Sheep sheep = null;
        try {
            //ǳ������������
            sheep = (Sheep) super.clone();
            //��� ���ö���
            sheep.friend = sheep.friend.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }

}
