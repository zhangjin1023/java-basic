package concurrent.producercomcumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 手写阻塞队列:基于条件变量
 *
 * @Author zhang_jin@suixingpay.com
 * @Date 23:27 2019/6/19
 * @Param
 * @return
 **/
public class BoundedBuffer {
    // 定义显式锁
    final Lock lock = new ReentrantLock();
    // 绑定非满条件
    final Condition notFull = lock.newCondition();
    // 绑定非空条件
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putPtr, takePtr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 数组元素满了，则生产者线程需要释放锁并进入阻塞状态，线程加入notFull条件对应的条件队列中
            // 当另一个线程调用了notFull.signal的时候，线程被唤醒，await方法返回。再次判断while条件的时候不为真，继续后续逻辑。
            while (count == items.length) {
                notFull.await();
            }
            items[putPtr] = x;
            if (++putPtr == items.length) {
                putPtr = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 数组空了，则消费者线程需要释放锁并进入阻塞状态，线程加入notEmpty条件对应的条件队列中
            // 当另一个线程调用了notEmpty.signal的时候，线程被唤醒，await方法返回。再次判断while条件的时候不为真，继续后续逻辑。
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takePtr];
            if (++takePtr == items.length) {
                takePtr = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        boundedBuffer.put("a");
        System.out.println(boundedBuffer.take().toString());
    }

}
