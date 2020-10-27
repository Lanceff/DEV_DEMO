package thread;

import sun.util.resources.ga.LocaleNames_ga;

import java.awt.event.TextEvent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Lance
 * @Date: 2020-10-16 16:11
 * @Description:
 */
public class ReentrantLockTest {

    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        /*Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();*/

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " execute");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();

                }
            }, "t" + i).start();
        }
        /*lock.lock();
        System.out.println("==============main========");
        lock.unlock();*/


    }

}
