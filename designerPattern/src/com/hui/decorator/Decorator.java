package com.hui.decorator;

/**
 * @description: װ�ν�ɫ������һ������(Component)�����ʵ����������һ������󹹼��ӿ�һ�µĽӿڡ�
 * @author: Lance
 * @create: 2020-07-27 09:04
 **/
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void opreation() {
        //ί�ɸ�����
        component.opreation();
    }
}
