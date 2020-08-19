package com.hui.bridge;

/**
 * @description: 桥接模式：将抽象部分与它的实现部分分离开来，使他们都可以独立变化。
 * @author: Lance
 * @create: 2020-07-20 08:55
 **/
public class Client {
    public static void main(String[] args) {
        BigSize c1 = new BigSize(new RedColor());
        c1.sizeDesc();
        SmallSize c2 = new SmallSize(new RedColor());
        c2.sizeDesc();

        BigSize c3 = new BigSize(new BlackColor());
        c3.sizeDesc();
        SmallSize c4 = new SmallSize(new BlackColor());
        c4.sizeDesc();

    }
}
