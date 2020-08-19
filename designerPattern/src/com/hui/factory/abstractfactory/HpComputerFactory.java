package com.hui.factory.abstractfactory;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-14 22:20
 **/
public class HpComputerFactory implements AbstractFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HpKeyboard();
    }
}
