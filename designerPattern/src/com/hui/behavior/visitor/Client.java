package com.hui.behavior.visitor;

/**
 * @author: Lance
 * @Date: 2020-08-21 09:00
 * @Description: ������ģʽ
 * ��������ĳ�����ݽṹ�еĸ�Ԫ�صĲ������������װ�ɶ������࣬ʹ���ڲ��ı����ݽṹ��ǰ���¿��������������ЩԪ�ص��µĲ�����
 * Ϊ���ݽṹ�е�ÿ��Ԫ���ṩ���ַ��ʷ�ʽ�����������ݵĲ��������ݽṹ���з��룬����Ϊ��ģʽ����ӵ�һ��ģʽ
 * ������ģʽ��ʹ�ó���:
 * 1.����ṹ�Ƚ��ȶ�����������Ҫ�ڴ˶���ṹ�϶����µĲ�����
 * 2.��Ҫ��һ������ṹ�еĶ�����кܶ಻ͬ�Ĳ��Ҳ���صĲ���������Ҫ������Щ��������Ⱦ����Щ������࣬Ҳ��ϣ���������²���ʱ�޸���Щ�ࡣ
 */
public class Client {

    public static void main(String[] args) {
        //�������������ߣ�ÿ�������߷���ʱ���������һ��
        ComputerPartVisitor visitorA = new ComputerPartDisplayVisitorA();
        ComputerPartVisitor visitorB = new ComputerPartDisplayVisitorB();

        //����ṹ,�������Ҫ������Ԫ�أ��ṩaccept()�������վ���ķ�����
        Computer computer = new Computer();
        computer.add(new Monitor());
        computer.add(new Mouse());
        computer.add(new Keyboard());

        //����
        computer.accept(visitorA);
        System.out.println("=========================");
        computer.accept(visitorB);
    }

}
