package com.hui.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:43
 * @Description: ��һ�������߶�����һ�������󶨣����ý�������Ӧ�Ĳ���
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
