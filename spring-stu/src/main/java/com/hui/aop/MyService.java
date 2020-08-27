package com.hui.aop;

import org.springframework.stereotype.Service;

/**
 * @author: Lance
 * @Date: 2020-08-27 18:33
 * @Description:
 */
@Service
public class MyService {

    public int divide(int a, int b) {
        int res = a / b;
        System.out.println("运算结果：" + res);
        return res;
    }
}
