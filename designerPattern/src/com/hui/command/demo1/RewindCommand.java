package com.hui.command.demo1;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:10
 * @Description: ���������ɫ: ������Ƶ
 */
public class RewindCommand implements Command {
    private AudioPlayer audio;

    public RewindCommand(AudioPlayer audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.rewind();
    }
}
