package com.hui.flyweight.demo;

import java.util.HashMap;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:52
 * @Description: ��Ԫ�����࣬���ڹ���һ��������(����)�� ͬʱ�ṩ�ӳ��л�ȡ���󷽷�
 */
public class WebSiteFactory {

    //���ϣ� �䵱�ص�����
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    //������վ�����ͣ�����һ����վ, ���û�оʹ���һ����վ�������뵽����,������
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    //��ȡ��վ��������� (�����ж��ٸ���վ����)
    public int getWebSiteCount() {
        return pool.size();
    }
}
