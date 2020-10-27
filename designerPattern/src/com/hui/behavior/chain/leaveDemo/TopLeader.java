package com.hui.behavior.chain.leaveDemo;

/**
 * @author: Lance
 * @Date: 2020-08-18 20:14
 * @Description:
 */
public class TopLeader extends Leader{
    @Override
    public void requestHandler(int leaveDays) {
        if(leaveDays<30){
            System.out.println("�����������30�죬�߲��쵼��׼��");
        }else {
            if (getNext() != null) {
                System.out.println("��������30�죬�߲��쵼��Ȩ�ޣ���Ҫ��ʾ�ϼ��쵼");
                //�¸��쵼������������
                getNext().requestHandler(leaveDays);
            }else {
                System.out.println("û���ϼ��ˣ��߲��쵼ֱ�Ӵ���");
            }
        }
    }
}
