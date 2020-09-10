package com.hui.state;

/**
 * @author: Lance
 * @Date: 2020-09-02 09:01
 * @Description: State 是抽象状态角色,定义一个接口封装与 Context 的一个特点接口相关行为
 */
public interface State {

    void doAction(String action);
}
