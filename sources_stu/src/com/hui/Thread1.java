package com.hui;

import java.util.concurrent.*;

/**
 * @author: Lance
 * @Date: 2020-09-09 15:12
 * @Description:
 */
public class Thread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        Thread1 t1 = new Thread1();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> res = service.submit(t1);
//        service.execute(()->{
//            System.out.println("");
//        });
        System.out.println(res.get());
        service.shutdown();


        ExecutorService service1 = new ThreadPoolExecutor(2,2,1000,TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(10));
        Future<?> submit = service1.submit(() -> {
            System.out.println();
        });
    }
}
