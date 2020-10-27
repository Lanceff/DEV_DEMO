package thread;

import java.util.concurrent.*;

/**
 * @author: Lance
 * @Date: 2020-10-15 14:48
 * @Description:
 * ThreadPoolExecutor参数：
 * 1.核心线程数
 * 2.最大线程数
 * 3.核心线程外空闲的线程销毁等待的时间
 * 4.keepAliveTime单位
 * 5.等待队列
 * 6.线程工厂：常用与给线程取名
 * 7.饱和策略:
 *          1)直接丢弃并且抛异常（默认）
 *          2)直接丢弃，不做其他操作
 *          3)将等待队列里最老的拿一个移除，重新提交任务
 *          4)直接用当前正在运行的主线程来执行该新任务
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                1000, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        /**
         * execute无返回值，submit有返回值
         */
        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t" + i);
            }
        });

        Future<Object> submit = executor.submit(new Callable() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
                return 0;
            }
        });
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end=====result:" + submit.get());
        executor.shutdown();

        //等待队列LinkedBlockingQueue，无限大
        Executors.newFixedThreadPool(2);
        Executors.newScheduledThreadPool(2);
        //最大线程数无限大Integer.MAX_VALUE
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
    }

}
