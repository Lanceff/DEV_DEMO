package com.hui.user;

import org.springframework.stereotype.Repository;

/**
 * @author: Lance
 * @Date: 2020-08-27 08:29
 * @Description:
 */
@Repository
public class MyDao {
    MyDao(){
        System.out.println("MyDao 构造");
    }

    public void printStr() {
        System.out.println("MyDao function exec。。。");
    }
}
