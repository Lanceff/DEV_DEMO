package com.hui.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: Lance
 * @Date: 2020-08-27 10:09
 * @Description:
 */
public class MyFactoryBean implements FactoryBean<FBean> {

    @Override
    public FBean getObject() {
        return new FBean();
    }

    @Override
    public Class<?> getObjectType() {
        return FBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
