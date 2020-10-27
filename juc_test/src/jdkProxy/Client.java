package jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @author: Lance
 * @Date: 2020-10-19 17:54
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Target obj = new RealObj();
        MyProxy proxy = new MyProxy(new RealObj());
        Target proxyObj = (Target)Proxy.newProxyInstance(proxy.getClass().getClassLoader(), obj.getClass().getInterfaces(), proxy);
        proxyObj.msg();
    }
}
