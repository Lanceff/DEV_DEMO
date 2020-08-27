package com.hui.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:14
 * @Description: ����ṹ��
 * ��һ������Ԫ�ؽ�ɫ���������ṩ�÷����߶�����������е�����Ԫ�صķ�����ͨ���� List��Set��Map �Ⱦۺ���ʵ�֡�
 */
public class Computer {

    private List<ComputerPart> list;

    public Computer() {
        list = new ArrayList();
    }

    public void accept(ComputerPartVisitor computerPartvisitor) {
        list.stream().forEach(element -> {
            element.accept(computerPartvisitor);
        });
    }

    public void add(ComputerPart element) {
        list.add(element);
    }

    public void remove(ComputerPart element) {
        list.remove(element);
    }

}
