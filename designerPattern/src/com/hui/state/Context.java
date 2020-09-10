package com.hui.state;

/**
 * @author: Lance
 * @Date: 2020-09-02 09:02
 * @Description: Context 类为环境角色, 用于维护 State 实例,这个实例定义当前状态
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.doAction("跑步");
    }
}
