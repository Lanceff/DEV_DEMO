package com.hui.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:55
 * @Description:
 */
public class TvOffCommand implements Command {
    private TvReceiver receiver;

    public TvOffCommand(TvReceiver receiver) {
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
