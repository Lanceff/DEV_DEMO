package com.hui.create.singleton;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 11:13
 **/
public class Client {

    public static void main(String[] args) {

        /*Leader1 zhangsan = Leader1.getInstance();
        Leader1 lisi = Leader1.getInstance();
        System.out.println(zhangsan.equals(lisi));*/


        /*Leader2 l21 = Leader2.getInstance();
        Leader2 l22 = Leader2.getInstance();
        System.out.println(l21.equals(l22));*/

        /*for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    Leader2 l21 = Leader2.getInstance();
                    Leader2 l22 = Leader2.getInstance();
                    if(l21.hashCode()!=l22.hashCode()){
                        System.out.println("懒汉式有线程安全问题");
                        break;
                    }
                }
            }).start();
        }*/

        /*Leader4 ld41 = Leader4.getInstance();
        Leader4 ld42 = Leader4.getInstance();
        System.out.println(ld41.hashCode());
        System.out.println(ld42.hashCode());*/

        Leader5 leader51 = Leader5.INSTANCE;
        Leader5 leader52 = Leader5.INSTANCE;
    }
}
