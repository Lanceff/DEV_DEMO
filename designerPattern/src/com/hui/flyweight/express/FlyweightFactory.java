package com.hui.flyweight.express;

import java.util.HashMap;

/**
 * @author: Lance
 * @Date: 2020-09-10 08:46
 * @Description: 享元工厂角色
 */
public class FlyweightFactory {

    private static final HashMap<String, Flyweight> flyweightMaps = new HashMap();

    public static Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMaps.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight();
            flyweightMaps.put(key, flyweight);
        }
        return flyweight;
    }
}
