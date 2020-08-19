package com.hui.chain.leaveDemo;

/**
 * @author: Lance
 * @Date: 2020-08-18 19:49
 * @Description:
 */
public abstract class Leader {

    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    public abstract void requestHandler(int leaveDays);
}
