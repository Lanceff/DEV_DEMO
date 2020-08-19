package com.hui.strategy;

/**
 * @description: 上下文类,持有一个策略类的引用，最终给客户端调用
 * @author: Lance
 * @create: 2020-07-18 08:20
 **/
public class Context {

    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void operator() {
        strategy.exec();
    }
}
