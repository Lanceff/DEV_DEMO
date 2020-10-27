package com.hui.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-09-10 10:27
 * @Description: ������н��߶���, ʵ�ֳ��󷽷�, ����Ҫ֪�����еľ����ͬ����,����һ������������,������ĳ��ͬ�¶�����Ϣ�������Ӧ������
 */
public class ConcreteMediator extends Mediator {

    /**
     * ���н��ߴ����ͬ��
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
