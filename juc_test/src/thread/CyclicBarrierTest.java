package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: Lance
 * @Date: 2020-10-17 17:17
 * @Description:
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier lock = new CyclicBarrier(5, () -> {
            System.out.println("放行吧==============");
        });

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println("thread" + Thread.currentThread().getName() + " wait");
                    lock.await();
                    System.out.println("thread" + Thread.currentThread().getName() + " run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "线程" + i).start();
        }


    }
}
