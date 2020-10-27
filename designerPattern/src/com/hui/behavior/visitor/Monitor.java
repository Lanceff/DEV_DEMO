package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:14
 * @Description: ����Ԫ����:��ʾ��
 * ʵ�ֳ���Ԫ�ؽ�ɫ�ṩ�� accept() �������䷽����ͨ������ visitor.visit(this) ���������Ԫ���п��ܻ���������ҵ���߼�����ز�����
 */
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
