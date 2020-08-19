package com.hui.singleton;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-16 13:42
 **/
public class Leader4 {

    private Leader4(){}

    public static Leader4 getInstance() {
        return LeaderHandler.instance;
    }

    static class LeaderHandler{
        private static final Leader4 instance = new Leader4();
    }
}
