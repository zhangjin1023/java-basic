package concurrent.threadcontrol;

/**
 * 写一个死锁的示例
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 * 思路：死锁的产生，在于多个线程在相互持有对方想要获取的锁，且不释放。
 */
public class DeadLockDemo {
    //定义两个线程，两个对象锁 并且两个线程获取锁的顺序不同就可以产生锁死
    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    synchronized (DeadLockDemo.lock1) {
                        System.out.println("Thread1 获取lock1");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        synchronized (DeadLockDemo.lock2) {
                            System.out.println("Thread1 获取lock2");
                        }

                    }
                }

            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    synchronized (DeadLockDemo.lock2) {
                        System.out.println("Thread2 获取lock2");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        synchronized (DeadLockDemo.lock1) {
                            System.out.println("Thread2 获取lock1");
                        }

                    }
                }

            }
        }).start();

    }

}
