package com.hui.create.prototype;

/**
 * @author: Lance
 * @Date: 2020-08-19 18:45
 * @Description: 原型模式, 浅拷贝
 * 1) 对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性值复制一份给新的对象。
 * 2) 对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行
 * 引用传递，也就是只是将该成员变量的引用值（内存地址）复制一份给新的对象。因为实际上两个对象的该成
 * 员变量都指向同一个实例。在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值
 *
 * 深拷贝 实现方式
 * 1：重写 clone 方法来实现深拷贝
 * 2：通过 对象序列化实现深拷贝(推荐)
 */
public class Client {
    public static void main(String[] args) {

        Sheep sheep = new Sheep("tom", 1, "黑色");
        Friend friend = new Friend("Calan", 2, "白色");
        sheep.setFriend(friend);

        Sheep sheep2 = sheep.clone(); //克隆
        Sheep sheep3 = sheep.clone(); //克隆
        Sheep sheep4 = sheep.clone(); //克隆
        Sheep sheep5 = sheep.clone(); //克隆

        //属于浅拷贝
        System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
        System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
        System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
        System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());
    }
}
