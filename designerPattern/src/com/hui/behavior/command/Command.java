package com.hui.behavior.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:34
 * @Description: ���������ɫ
 */
public interface Command {

    //ִ�ж���(����)
    void execute();

    //��������(����)
    void undo();
}
