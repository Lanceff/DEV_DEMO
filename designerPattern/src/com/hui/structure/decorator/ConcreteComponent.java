package com.hui.structure.decorator;

/**
 * @description: ���幹����ɫ������һ����Ҫ���ո������ε���
 * @author: Lance
 * @create: 2020-07-27 09:02
 **/
public class ConcreteComponent  implements  Component{

    @Override
    public void opreation() {
        System.out.println("ԭ��ҵ��ִ��");
    }
}
