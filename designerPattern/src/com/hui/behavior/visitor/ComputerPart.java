package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:08
 * @Description: ����Ԫ����:����һ���������ܲ��� accept() �Ľӿڣ������ܵķ����߶�����Ϊ accept() �����Ĳ�����
 */
public interface ComputerPart  {

    void accept(ComputerPartVisitor computerPartVisitor);
}
