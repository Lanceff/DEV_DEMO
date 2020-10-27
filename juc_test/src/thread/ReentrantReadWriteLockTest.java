package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Lance
 * @Date: 2020-10-17 20:08
 * @Description:
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock read = lock.readLock();
        Lock write = lock.writeLock();


        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                read.lock();
                System.out.println(Thread.currentThread().getName() + " running");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                read.unlock();
            }, "read thread " + i).start();
        }

    }
}
