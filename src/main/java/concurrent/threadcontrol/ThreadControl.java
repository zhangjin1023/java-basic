package concurrent.threadcontrol;

/*
 * 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 *
 * 注意：采用下面的方法无法实现控制。start方法的先后无法控制。
 */
public class ThreadControl {

    //20190430-补充，这种方式问题就是出现在join方法必须要在对应的线程已经调用过start方法才能起到同步的效果
    // 然而，三个线程start方法的先后无法控制。如果t3.start后睡眠一会儿，t2.start还没有执行的情况下，
    // 就在t3的run方法中调用t2.join是没有作用的。
    // 参考：https://www.cnblogs.com/lcplcpjava/p/6896904.html
    public static void main(String[] args) {
        final Thread t1 = new Thread(() -> System.out.println("t1 running"));

        final Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 running");
        });

        final Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 running");
        });
        t3.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t1.start();

    }

}
