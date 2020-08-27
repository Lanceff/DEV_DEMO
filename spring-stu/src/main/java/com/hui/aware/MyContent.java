package com.hui.aware;

import java.util.HashMap;

/**
 * @author: Lance
 * @Date: 2020-08-27 16:28
 * @Description:
 */
public class MyContent {
    public HashMap hashMap = null;

    public MyContent() {
        hashMap = new HashMap();
    }

    public void put(String key, Object value) {
        hashMap.put(key, value);
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}
