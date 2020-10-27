package com.hui.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:27
 * @Description: 具体的中介者对象, 实现抽象方法, 他需要知道所有的具体的同事类,即以一个集合来管理,并接受某个同事对象消息，完成相应的任务
 */
public class ConcreteMediator extends Mediator {

    /**
     * 被中介者代理的同事
     */
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleague.setMediator(this);
            this.colleagues.add(colleague);
        }
    }

    public void relay(Colleague colleague) {
        colleagues.forEach(c -> {
            if (!c.equals(colleague)) {
                c.receive();
            }
        });
    }
}
