package com.hui.state;

/**
 * @author: Lance
 * @Date: 2020-09-02 09:08
 * @Description: ConcreteState 具体的状态角色，每个子类实现一个与 Context 的一个状态相关行为
 */
public class StartState implements State {

    @Override
    public void doAction(String action) {
        System.out.println("StartState" + action);
    }

}
