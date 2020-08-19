package com.hui.command.demo1;

/**
 * @author: Lance
 * @Date: 2020-08-05 10:10
 * @Description: ���������ɫ: ִ�в���
 */
public class PlayCommand implements Command {
    private AudioPlayer audio;

    public PlayCommand(AudioPlayer audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.play();
    }
}
