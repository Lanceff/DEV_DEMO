package com.hui.behavior.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:34
 * @Description: 抽象命令角色
 */
public interface Command {

    //执行动作(操作)
    void execute();

    //撤销动作(操作)
    void undo();
}
