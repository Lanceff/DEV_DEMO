package com.hui.behavior.state;

/**
 * @author: Lance
 * @Date: 2020-09-02 08:45
 * @Description: 状态模式
 * 主要用来解决对象在多种状态转换时，需要对外输出不同的行为的问题。状态和行为是一一对应的，状态之间可以相互转换
 *
 * 1）Context(环境类)：环境类拥有各种不同状态的对象，作为外部使用的接口，负责调用状态类接口。
 * 2）State(抽象状态)：抽象状态既可以为抽象类，也可以直接定义成接口。主要用于定义状态抽象方法，具体实现由子类负责。
 * 3）ConcreteState(具体状态类):具体状态类为抽象状态的实现者，不同的状态类对应这不同的状态，其内部实现也不相同。环境类中使用不同状态的对象时，能实现不同的处理逻辑。
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        context.setState(startState);
        context.request();

        StopState stopState = new StopState();
        context.setState(stopState);
        context.request();
    }
}
