package com.hui.command.demo1;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:27
 * @Description: �����߽�ɫ(Invoker)
 */
public class Keypad {

    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    /**
     * ִ�в��ŷ���
     */
    public void play() {
        playCommand.execute();
    }

    /**
     * ִ�е�������
     */
    public void rewind() {
        rewindCommand.execute();
    }

    /**
     * ִ��ֹͣ���ŵķ���
     */
    public void stop() {
        stopCommand.execute();
    }
}
