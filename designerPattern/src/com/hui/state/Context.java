package com.hui.state;

/**
 * @author: Lance
 * @Date: 2020-09-02 09:02
 * @Description: Context ��Ϊ������ɫ, ����ά�� State ʵ��,���ʵ�����嵱ǰ״̬
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.doAction("�ܲ�");
    }
}
