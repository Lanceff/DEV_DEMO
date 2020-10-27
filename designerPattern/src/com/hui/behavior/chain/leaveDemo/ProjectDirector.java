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
            System.out.println("请假天数少于7天，项目总监批准了");
        } else {
            if (getNext() != null) {
                System.out.println("天数大于7天，项目总监无权限，需要请示上级领导");
                //下个领导进行审批处理
                getNext().requestHandler(leaveDays);
            } else {
                System.out.println("没有上级了，项目总监直接处理");
            }
        }
    }
}
