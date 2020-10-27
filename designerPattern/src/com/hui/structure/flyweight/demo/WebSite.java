package com.hui.structure.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description: 抽象的享元角色, 他是产品的抽象类, 同时定义出对象的外部状态和内部状态(后面介绍) 的接口
 * 或实现
 */
public interface WebSite {

    void use(OutsideUser user);
}
