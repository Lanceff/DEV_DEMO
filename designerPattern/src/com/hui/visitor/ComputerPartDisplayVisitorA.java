package com.hui.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:15
 * @Description: ��������߽�ɫA:ʵ�ֳ�������߽�ɫ�������ĸ������ʲ�����ȷ�������߷���һ��Ԫ��ʱ����ʲô
 */
public class ComputerPartDisplayVisitorA implements ComputerPartVisitor {

    @Override
    public void visit(Mouse mouse) {
        System.out.println("�������.������A���з��ʣ�A�߼�����");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("���Ǽ���.������A���з��ʣ�A�߼�����");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("������ʾ��.������A���з��ʣ�A�߼�����");
    }
}
