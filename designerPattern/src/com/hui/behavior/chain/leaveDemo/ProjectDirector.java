package com.hui.behavior.chain.leaveDemo;

/**
 * @author: Lance
 * @Date: 2020-08-18 20:10
 * @Description:
 */
public class ProjectDirector extends Leader {
    @Override
    public void requestHandler(int leaveDays) {
        if (leaveDays < 7) {
            System.out.println("�����������7�죬��Ŀ�ܼ���׼��");
        } else {
            if (getNext() != null) {
                System.out.println("��������7�죬��Ŀ�ܼ���Ȩ�ޣ���Ҫ��ʾ�ϼ��쵼");
                //�¸��쵼������������
                getNext().requestHandler(leaveDays);
            } else {
                System.out.println("û���ϼ��ˣ���Ŀ�ܼ�ֱ�Ӵ���");
            }
        }
    }
}
