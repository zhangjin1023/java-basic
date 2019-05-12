package zookeeper.curator;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class RecipesNoLock {
    public static void main(String[] args) {
        // 使用阀门类，达到控制多个线程同一时刻并发执行的效果
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.out.println("生成的订单号是: " + orderNo);
            }).start();
        }
        countDownLatch.countDown();
    }
}
