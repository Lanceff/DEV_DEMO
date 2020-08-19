package com.hui.facade;

/**
 * @description:Õ‚π€¿‡
 * @author: Lance
 * @create: 2020-07-28 09:15
 **/
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    Facade() {
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();
    }

    void systemAMethod() {
        systemA.methodA();
    }

    void systemBMethod() {
        systemB.methodB();
    }

    void systemCMethod() {
        systemC.methodC();
    }
}
