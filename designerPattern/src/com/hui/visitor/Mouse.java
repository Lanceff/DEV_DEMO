package com.hui.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:14
 * @Description: ����Ԫ����:���
 * ʵ�ֳ���Ԫ�ؽ�ɫ�ṩ�� accept() �������䷽����ͨ������ visitor.visit(this) ���������Ԫ���п��ܻ���������ҵ���߼�����ز�����
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}