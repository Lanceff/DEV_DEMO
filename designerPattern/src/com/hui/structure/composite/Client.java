package com.hui.structure.composite;

/**
 * @author: Lance
 * @Date: 2020-08-15 09:55
 * @Description: ���ģʽ   ������
 * ��ͼ�� ��������ϳ����νṹ�Ա�ʾ"����-����"�Ĳ�νṹ�����ģʽʹ���û��Ե����������϶����ʹ�þ���һ���ԡ�
 * ��Ҫ����������������ͽṹ�������У�ģ���˼�Ԫ�غ͸���Ԫ�صĸ���ͻ�������������Ԫ��һ����������Ԫ�أ��Ӷ�ʹ�ÿͻ������븴��Ԫ�ص��ڲ��ṹ���
 * ��ʱʹ�ã� 1�������ʾ����Ĳ���-�����νṹ�����νṹ���� 2����ϣ���û�������϶����뵥������Ĳ�ͬ���û���ͳһ��ʹ����Ͻṹ�е����ж���
 * ��ν������֦��Ҷ��ʵ��ͳһ�ӿڣ���֦�ڲ���ϸýӿڡ�
 */
public class Client {

    public static void main(String[] args) {
        Employee CEO = new Employee("���³�", "CEO", 50000);
        Employee leader1 = new Employee("-- �ɲ�1", "head", 20000);
        Employee leader2 = new Employee("-- �ɲ�2", "head", 20000);
        CEO.add(leader1);
        CEO.add(leader2);

        Employee emp1 = new Employee("---- Ա��1", "emp", 10000);
        Employee emp2 = new Employee("---- Ա��2", "emp", 10000);
        Employee emp3 = new Employee("---- Ա��3", "emp", 10000);
        Employee emp4 = new Employee("---- Ա��4", "emp", 10000);

        leader1.add(emp1);
        leader1.add(emp2);
        leader2.add(emp3);
        leader2.add(emp4);

        System.out.println(CEO);

        CEO.getSubordinates().stream().forEach(e->{
            System.out.println(e);
            e.getSubordinates().stream().forEach(System.out::println);
        });
    }
}
