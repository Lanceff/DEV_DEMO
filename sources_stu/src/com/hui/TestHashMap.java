package com.hui;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: Lance
 * @Date: 2020-09-08 11:31
 * @Description:
 */
public class TestHashMap {

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        a.incrementAndGet();
        AtomicLong b = new AtomicLong();
        b.getAndSet(1);
        AtomicBoolean c = new AtomicBoolean();
        /*HashMap<String, Object> hashMap = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            hashMap.put("key" + i, "value" + i);
            if (i == 10) {
                hashMap.put("key" + i, "value" + i);
            }
        }*/
        /*ArrayList<String> arrayList = new ArrayList<>();
        for (int j = 0; j < 25; j++) {
            arrayList.add("hello"+j);
        }*/
    }
}
