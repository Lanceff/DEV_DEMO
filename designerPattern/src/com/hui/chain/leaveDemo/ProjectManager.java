package com.hui.chain.leaveDemo;

/**
 * @author: Lance
 * @Date: 2020-08-18 20:02
 * @Description:
 */
public class ProjectManager extends Leader {
    @Override
    public void requestHandler(int leaveDays) {
        if (leaveDays <= 2) {
            System.out.println("��������2�죬��Ŀ������׼��");
        } else {
            if (getNext() != null) {
                System.out.println("��������2�죬��Ŀ������Ȩ�ޣ���Ҫ��ʾ��Ŀ�ܼ�");
                //�¸��쵼������������
                getNext().requestHandler(leaveDays);
            }else {
                System.out.println("û���ϼ��ˣ���Ŀ����ֱ�Ӵ���");
            }
        }
    }
}
