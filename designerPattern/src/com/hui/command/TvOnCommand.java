package com.hui.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:55
 * @Description:
 */
public class TvOnCommand implements Command {
    private TvReceiver receiver;

    public TvOnCommand(TvReceiver receiver) {
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
