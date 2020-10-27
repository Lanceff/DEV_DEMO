package com.hui.tx;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Lance
 * @Date: 2020-10-20 14:59
 * @Description:
 */
@Component
public class MyService {

    @Transactional
    public void test(){

    }
}
