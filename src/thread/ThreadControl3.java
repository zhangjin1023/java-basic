package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 * 有三个线程分别打印A、B、C,请用多线程编程实现，在屏幕上循环打印10次ABCABC…
 * 
 * 
 */
public class ThreadControl3 {
	//注意；信号量A初始化的时候带有一个许可，B和C初始化的时候不带许可
	//三个线程就绪之后，只有线程A可以立刻获得许可，线程B和C因为无法获取许可而进入阻塞状态
	//等待线程A执行结束之后，线程A会释放一个许可给信号量B,此时信号量A和C中没有许可，只有B中有一个许可
	//线程B从信号量B中获取许可之后运行，结束之后线程B会释放一个许可给信号量C,此时信号量A和B中没有许可，只有C中有一个许可
	//线程C从信号量C中获取许可之后运行，结束之后线程C会释放一个许可给信号量A.回归到初始化状态。
	//如此循环10次
	private Semaphore semaphoresA = new Semaphore(1);
	private Semaphore semaphoresB = new Semaphore(0);
	private Semaphore semaphoresC = new Semaphore(0);

	public static void main(String[] args) {
		ThreadControl3 example = new ThreadControl3();
		ExecutorService service = Executors.newFixedThreadPool(3);

		service.execute(example.new RunnableA());
		service.execute(example.new RunnableB());
		service.execute(example.new RunnableC());

		service.shutdown();

	}

	private class RunnableA implements Runnable {

		public void run() {

			for (int i = 0; i < 10; i++) {
				try {
					semaphoresA.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(String.format("第%d遍", i + 1));
				System.out.println("A");
				semaphoresB.release();

			}
		}
	}

	private class RunnableB implements Runnable {

		public void run() {

			for (int i = 0; i < 10; i++) {
				try {
					semaphoresB.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("B");
				semaphoresC.release();
			}

		}
	}

	private class RunnableC implements Runnable {

		public void run() {

			for (int i = 0; i < 10; i++) {
				try {
					semaphoresC.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("C");
				System.out.println();

				semaphoresA.release();
			}
		}
	}

}
