package com.hui.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:15
 * @Description: ��������߽�ɫ:����һ�����ʾ���Ԫ�صĽӿڣ�Ϊÿ������Ԫ�����Ӧһ�����ʲ��� visit() ���ò����еĲ������ͱ�ʶ�˱����ʵľ���Ԫ�ء�
 */
public interface ComputerPartVisitor {

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

}
