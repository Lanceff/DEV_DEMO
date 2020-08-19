package com.hui.command.demo1;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:13
 * @Description: 接收者角色(Receiver),真正的命令执行对象
 */
public class AudioPlayer  {

    void play(){
        System.out.println("播放音频");
    }

    void rewind() {
        System.out.println("执行倒带");
    }

    void stop() {
        System.out.println("停止播放");
    }
}
