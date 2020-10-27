package thread;

import java.util.concurrent.*;

/**
 * @author: Lance
 * @Date: 2020-10-15 14:48
 * @Description:
 * ThreadPoolExecutor������
 * 1.�����߳���
 * 2.����߳���
 * 3.�����߳�����е��߳����ٵȴ���ʱ��
 * 4.keepAliveTime��λ
 * 5.�ȴ�����
 * 6.�̹߳�������������߳�ȡ��
 * 7.���Ͳ���:
 *          1)ֱ�Ӷ����������쳣��Ĭ�ϣ�
 *          2)ֱ�Ӷ�����������������
 *          3)���ȴ����������ϵ���һ���Ƴ��������ύ����
 *          4)ֱ���õ�ǰ�������е����߳���ִ�и�������
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                1000, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        /**
         * execute�޷���ֵ��submit�з���ֵ
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

        //�ȴ�����LinkedBlockingQueue�����޴�
        Executors.newFixedThreadPool(2);
        Executors.newScheduledThreadPool(2);
        //����߳������޴�Integer.MAX_VALUE
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
    }

}
