package com.hui.strategy;

/**
 * @description: ��������,����һ������������ã����ո��ͻ��˵���
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
