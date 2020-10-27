package com.hui.behavior.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:44
 * @Description: 将一个接受者对象与一个动作绑定，调用接受者相应的操作
 */
public class LightOnCommand implements Command {
    private LightReceiver receiver;

    LightOnCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.on();
    }

    @Override
    public void undo() {
        receiver.off();
    }
}
