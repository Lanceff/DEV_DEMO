package com.hui.structure.bridge;

/**
 * @description: 桥接模式（多维度变化）：将抽象部分与它的实现部分分离开来，使他们都可以独立变化。
 * 桥接模式通常适用于以下场景：
 * 1.当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 * 2.当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
 * 3.当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。
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
