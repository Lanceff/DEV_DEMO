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
            System.out.println("天数少于2天，项目经理批准了");
        } else {
            if (getNext() != null) {
                System.out.println("天数大于2天，项目经理无权限，需要请示项目总监");
                //下个领导进行审批处理
                getNext().requestHandler(leaveDays);
            }else {
                System.out.println("没有上级了，项目经理直接处理");
            }
        }
    }
}
