package com.hui.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description: 具体的享元角色，是具体的产品类，实现抽象角色定义相关业务
 */
public class ConcreteWebSite implements WebSite{

    //共享的部分，内部状态
    private String type = ""; //网站发布的形式(类型)
    //构造器
    public ConcreteWebSite(String type) {
        this.type = type;
    }
    @Override
    public void use(OutsideUser user) {
        System.out.println("网站的发布形式为:" + type + " 在使用中 .. 使用者是" + user.getName());
    }
}
