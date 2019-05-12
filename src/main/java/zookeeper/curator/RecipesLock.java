package zookeeper.curator;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class RecipesLock {
    private static String LOCK_PATH = "/zk-book/curator/recipes_lock";

    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181").retryPolicy(
                new ExponentialBackoffRetry(1000, 3)
        ).build();
        client.start();

        final InterProcessMutex lock = new InterProcessMutex(client, LOCK_PATH);

        // 使用阀门类，达到控制多个线程同一时刻并发执行的效果
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    lock.acquire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.out.println("生成的订单号是: " + orderNo);
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
