package concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * All rights Reserved, Designed By Suixingpay.
 * 有三个线程分别打印A、B、C,请用多线程编程实现，在屏幕上循环打印10次ABCABC…
 *
 * @author: 张锦
 * @date: 2019/4/29 19:35
 * @Copyright ©2019 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class ConditionTest {
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private String type = "A";

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionTest.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionTest.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionTest.printC();
            }
        }).start();

    }

    public void printA() {
        try {
            lock.lock();
            while (!"A".equals(type)) {
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            type = "B";
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();
            while (!"B".equals(type)) {
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            type = "C";
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        try {
            lock.lock();
            while (!"C".equals(type)) {
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            type = "A";
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }
}
