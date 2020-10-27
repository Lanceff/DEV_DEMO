package com.hui.behavior.template;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 10:53
 **/
public class WangzheGame extends Game{

    @Override
    void initialize() {
        System.out.println("安装王者荣耀");
    }

    @Override
    void startPlay() {
        System.out.println("开始玩王者荣耀哟，胜利");
    }

    @Override
    void endPlay() {
        System.out.println("结束玩王者荣耀");
    }
}
