package com.hui.behavior.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:44
 * @Description: ��һ�������߶�����һ�������󶨣����ý�������Ӧ�Ĳ���
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
