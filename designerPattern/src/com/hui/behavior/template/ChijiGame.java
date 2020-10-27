package com.hui.behavior.template;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 10:56
 **/
public class ChijiGame extends Game {
    @Override
    void initialize() {
        System.out.println("安装和平精英");
    }

    @Override
    void startPlay() {
        System.out.println("开始玩和平精英哟，吃鸡了");
    }

    @Override
    void endPlay() {
        System.out.println("结束玩和平精英");
    }
}
