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
            System.out.println("请假天数少于30天，高层领导批准了");
        }else {
            if (getNext() != null) {
                System.out.println("天数大于30天，高层领导无权限，需要请示上级领导");
                //下个领导进行审批处理
                getNext().requestHandler(leaveDays);
            }else {
                System.out.println("没有上级了，高层领导直接处理");
            }
        }
    }
}
