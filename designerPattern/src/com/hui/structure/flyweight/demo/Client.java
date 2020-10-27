package com.hui.structure.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        // ����һ��������
        WebSiteFactory factory = new WebSiteFactory();
        // �ͻ�Ҫһ����������ʽ��������վ
        WebSite webSite1 = factory.getWebSiteCategory("����");
        webSite1.use(new OutsideUser("tom"));
        // �ͻ�Ҫһ���Բ�����ʽ��������վ
        WebSite webSite2 = factory.getWebSiteCategory("����");
        webSite2.use(new OutsideUser("jack"));
        // �ͻ�Ҫһ���Բ�����ʽ��������վ
        WebSite webSite3 = factory.getWebSiteCategory("����");
        webSite3.use(new OutsideUser("smith"));
        // �ͻ�Ҫһ���Բ�����ʽ��������վ
        WebSite webSite4 = factory.getWebSiteCategory("����");
        webSite4.use(new OutsideUser("king"));
        System.out.println("��վ�ķ��๲=" + factory.getWebSiteCount());
    }
}
