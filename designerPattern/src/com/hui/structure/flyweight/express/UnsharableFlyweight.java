package com.hui.structure.flyweight.express;

/**
 * @author: Lance
 * @Date: 2020-10-13 08:33
 * @Description: 非享元角色：是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中
 */
public class UnsharableFlyweight {
    private String info;

    UnsharableFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
