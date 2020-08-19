package com.hui.template;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 10:17
 **/
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板
    final void play() {
        //初始化游戏
        initialize();
        //开始游戏
        startPlay();
        //结束游戏
        endPlay();
    }
}
