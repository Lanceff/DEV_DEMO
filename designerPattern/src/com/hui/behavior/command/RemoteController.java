package com.hui.behavior.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:48
 * @Description: 命令调用者
 */
public class RemoteController {

    // 开 按钮的命令数组
    Command[] onCommands;
    // 关 按钮的命令数组
    Command[] offCommands;
    // 执行撤销的命令
    Command undoCommand;

    /**
     * 构造器，完成对按钮初始化
     */
    public RemoteController() {
        onCommands = new Command[2];
        offCommands = new Command[2];
        for (int i = 0; i < 2; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    /**
     * 给我们的按钮设置你需要的命令
     *
     * @param no
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    /**
     * 按下开按钮
     *
     * @param no
     */
    public void onButtonWasPushed(int no) {
        // 找到你按下的开的按钮， 并调用对应方法
        onCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = onCommands[no];

    }

    /**
     * 按下开按钮
     *
     * @param no
     */
    public void offButtonWasPushed(int no) {
        // 找到你按下的关的按钮， 并调用对应方法
        offCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = offCommands[no];

    }

    /**
     * 按下撤销按钮
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

}
