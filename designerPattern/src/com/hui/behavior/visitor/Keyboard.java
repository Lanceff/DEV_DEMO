package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:09
 * @Description: ����Ԫ����:����
 * ʵ�ֳ���Ԫ�ؽ�ɫ�ṩ�� accept() �������䷽����ͨ������ visitor.visit(this) ���������Ԫ���п��ܻ���������ҵ���߼�����ز�����
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
