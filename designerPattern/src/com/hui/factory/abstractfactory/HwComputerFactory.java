package com.hui.factory.abstractfactory;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-14 22:21
 **/
public class HwComputerFactory implements AbstractFactory{
    @Override
    public Mouse createMouse() {
        return new HwMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HwKeyboard();
    }
}
