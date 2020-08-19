package com.hui.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:43
 * @Description: 将一个接受者对象与一个动作绑定，调用接受者相应的操作
 */
public class LightOffCommand implements Command {
    private LightReceiver receiver;

    LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.off();
    }

    @Override
    public void undo() {
        receiver.on();
    }
}
