import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Lance
 * @Date: 2020-10-13 10:41
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Integer a1 = -128;   //-128~127
        Integer a2 = -128;
        Integer b1 = 129;
        Integer b2 = 129;
        Integer a3 = new Integer(10);
        Integer a4 = new Integer(10);
        System.out.println(a1==a2);
        System.out.println(b1==b2);
        System.out.println(a3==a4);
        Integer c1 = 129;
        int c2 = 129;
        System.out.println(c1==c2);//c1×Ö¶Î²ðÏä

       /* ExecutorService service = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock(true);

        *//*ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock1.readLock();
        readLock.lock();*//*

        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1-" + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2-" + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();*/
    }
}
