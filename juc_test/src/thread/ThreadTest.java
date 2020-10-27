package thread;

/**
 * @author: Lance
 * @Date: 2020-10-16 17:00
 * @Description:
 */
public class ThreadTest {
    public static Thread t1;
    public static Thread t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("t1:" + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("t2:" + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        t2.start();

    }
}
