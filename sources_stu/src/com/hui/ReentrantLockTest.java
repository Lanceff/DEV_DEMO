package com.hui;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Lance
 * @Date: 2020-09-09 16:55
 * @Description:
 */
public class ReentrantLockTest {
    public static int count = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread[] threads = new Thread[20];
        for (int i = 0; i <= threads.length - 1; i++) {
            threads[i] = new Thread(() -> {
                lock.lock();
                count++;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count);
                lock.unlock();
            }, "thread-" + i);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }


    }
}
