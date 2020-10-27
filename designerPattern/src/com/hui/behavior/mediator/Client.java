package com.hui.behavior.mediator;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:10
 * @Description: �н���ģʽ
 * ��ͼ����һ���н��������װһϵ�еĶ��󽻻����н���ʹ��������Ҫ��ʽ���໥���ã��Ӷ�ʹ�������ɢ�����ҿ��Զ����ظı�����֮��Ľ�����
 * ��Ҫ��������������֮����ڴ����Ĺ�����ϵ�������Ʊػᵼ��ϵͳ�Ľṹ��úܸ��ӣ�ͬʱ��һ���������ı䣬����Ҳ��Ҫ������֮������Ķ���ͬʱ������Ӧ�Ĵ���
 * ��ʱʹ�ã�������໥��ϣ��γ�����״�ṹ��
 * ��ν������������״�ṹ����Ϊ���ͽṹ��
 * �ؼ����룺���� Colleague ֮���ͨ�ŷ�װ��һ�����е�������
 * Ӧ��ʵ���� 1���й����� WTO ֮ǰ�Ǹ��������໥ó�ף��ṹ���ӣ������Ǹ�������ͨ�� WTO ������ó�ס� 2����������ϵͳ�� 3��MVC ��ܣ�����C�������������� M��ģ�ͣ��� V����ͼ�����н��ߡ�
 * �ŵ㣺 1����������ĸ��Ӷȣ���һ�Զ�ת������һ��һ�� 2��������֮��Ľ�� 3�����ϵ�����ԭ��
 * ȱ�㣺�н��߻��Ӵ󣬱�ø�������ά����
 * ʹ�ó����� 1��ϵͳ�ж���֮����ڱȽϸ��ӵ����ù�ϵ����������֮���������ϵ�ṹ���Ҷ������Ը��øö��� 2����ͨ��һ���м�������װ������е���Ϊ�����ֲ�������̫������ࡣ
 * ע�������Ӧ����ְ����ҵ�ʱ��ʹ�á�
 */
public class Client {

    public static void main(String[] args) {
        //�����н���
        Mediator mediator1 = new ConcreteMediator();
        Mediator mediator2 = new ConcreteMediator();

        //���������ͬ����
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        Colleague colleague3 = new ConcreteColleague3();
        Colleague colleague4 = new ConcreteColleague4();
        //ע��ͬ��ͨ��Ⱥ��
        mediator1.register(colleague1);
        mediator1.register(colleague2);
        //��һ��Ⱥ��
        mediator2.register(colleague2);
        mediator2.register(colleague3);
        mediator2.register(colleague4);

        //������Ϣ
        colleague1.send();
        System.out.println("===============");
//        colleague2.send();
//        System.out.println("===============");
//        colleague3.send();
    }
}
