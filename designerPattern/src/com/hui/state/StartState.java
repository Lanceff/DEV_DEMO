package com.hui.state;

/**
 * @author: Lance
 * @Date: 2020-09-02 09:08
 * @Description: ConcreteState �����״̬��ɫ��ÿ������ʵ��һ���� Context ��һ��״̬�����Ϊ
 */
public class StartState implements State {

    @Override
    public void doAction(String action) {
        System.out.println("StartState" + action);
    }

}
