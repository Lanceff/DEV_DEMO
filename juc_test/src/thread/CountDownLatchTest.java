package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: Lance
 * @Date: 2020-10-17 17:05
 * @Description:
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(50);

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("¼ÆÊý-1..." + i);
                latch.countDown();
                System.out.println("count=" + latch.getCount());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+" continue run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t" + i).start();
        }
    }
}
