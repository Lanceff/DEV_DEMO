package com.hui.behavior.chain.leaveDemo;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:48
 * @Description:
 * ְ����ģʽ�����������������
 * 1.����ְ����ģʽ��һ��������뱻ĳһ�������߶��������գ���һ�����崦���߶�ĳ������Ĵ���ֻ�ܲ�������������Ϊ֮һ���Լ������е����Σ����������Ƹ��¼Ҵ���
 * 2.������ְ����ģʽ���������ĳһ�����崦���߶����ڳе��������һ�������κ��ֽ�ʣ������δ����¼ҵ��������һ������������ղ����κν��ն˶��������ա�
 */
public class Client {

    public static void main(String[] args) {
        Leader projectManager = new ProjectManager();
        Leader projectDirector = new ProjectDirector();
        Leader topLeader = new TopLeader();
        projectManager.setNext(projectDirector);
        projectDirector.setNext(topLeader);

        //���5��
        projectManager.requestHandler(10);
    }
}
