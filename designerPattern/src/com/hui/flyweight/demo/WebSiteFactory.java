package com.hui.flyweight.demo;

import java.util.HashMap;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:52
 * @Description: 享元工厂类，用于构建一个池容器(集合)， 同时提供从池中获取对象方法
 */
public class WebSiteFactory {

    //集合， 充当池的作用
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    //根据网站的类型，返回一个网站, 如果没有就创建一个网站，并放入到池中,并返回
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    //获取网站分类的总数 (池中有多少个网站类型)
    public int getWebSiteCount() {
        return pool.size();
    }
}
