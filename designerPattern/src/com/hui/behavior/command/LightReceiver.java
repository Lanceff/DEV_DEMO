package com.hui.behavior.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:41
 * @Description: 接收者角色, 真正的命令执行对象
 */
public class LightReceiver {

    public void on() {
        System.out.println("电灯打开了..");
    }

    public void off() {
        System.out.println("电灯关闭了..");
    }

}
