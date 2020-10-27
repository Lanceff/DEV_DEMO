package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Lance
 * @Date: 2020-10-19 17:50
 * @Description:
 */
public class MyProxy implements InvocationHandler {
    Object realObj = null;

    MyProxy(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hello£¬proxy run¡£¡£¡£");
        Object obj = method.invoke(realObj, args);
        return obj;
    }
}
