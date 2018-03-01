package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCoundDownLatch {
	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(10);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			executorService.execute(new MyThread(count, index));
		}

		try {
			count.await();
			System.out.println("所有子线程结束,耗时：" + (System.currentTimeMillis() - start) + "ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class MyThread implements Runnable {
	CountDownLatch count;
	private int index;

	public MyThread(CountDownLatch count, int index) {
		super();
		this.count = count;
		this.index = index;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
			System.out.println("线程结束:" + index);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			count.countDown();
		}

	}

}
