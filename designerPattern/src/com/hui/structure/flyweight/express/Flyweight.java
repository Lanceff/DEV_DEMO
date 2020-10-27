package com.hui.structure.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-09-10 08:45
 * @Description: 抽象享元角色:是所有的具体享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入。
 */
public interface Flyweight {

    void operator();
    void operator1(UnsharableFlyweight unsharableFlyweight);
}
