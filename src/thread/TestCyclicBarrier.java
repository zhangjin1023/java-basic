package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 回环栅栏
 * 
 * @author zhang_jin[zhang_jin@suixingpay.com]
 *         CyclicBarrier是一个同步辅助类，它允许一组线程互相等待， 直到所有线程都到达某个公共屏障点(也可以叫同步点)，
 *         即相互等待的线程都完成调用await方法， 所有被屏障拦截的线程才会继续运行await方法后面的程序。
 */
public class TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread1 prepare");

				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread1 run");

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread2 prepare");

				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread2 run");

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread3 prepare");

				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread3 run");

			}
		}).start();
	}

}
