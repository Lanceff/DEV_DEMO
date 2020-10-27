package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:15
 * @Description: ��������߽�ɫB:ʵ�ֳ�������߽�ɫ�������ĸ������ʲ�����ȷ�������߷���һ��Ԫ��ʱ����ʲô
 */
public class ComputerPartDisplayVisitorB implements ComputerPartVisitor {

    @Override
    public void visit(Mouse mouse) {
        System.out.println("�������.������B���з��ʣ�B�߼�����");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("���Ǽ���.������B���з��ʣ�B�߼�����");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("������ʾ��.������B���з��ʣ�B�߼�����");
    }
}
