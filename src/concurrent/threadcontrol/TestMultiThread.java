package concurrent.threadcontrol;

import java.util.concurrent.locks.ReentrantLock;

public class TestMultiThread {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        TestMultiThread test = new TestMultiThread();

        Thread test1 = new Thread(new Runnable() {
            public void run() {
                test.print1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                test.print2();
            }
        }, "test1");

        test1.start();
        test2.start();
    }

    public void print1() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("1");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void print2() {
        synchronized ("1") {
            for (int i = 0; i < 10; i++) {
                System.out.println("2");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


}
