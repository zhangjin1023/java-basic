package thread;

/*
 * 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行  
 * 
 * 注意：采用下面的方法无法实现控制。start方法的先后无法控制。
 */
public class ThreadControl {

	public static void main(String[] args) {
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t1 running");
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 running");
			}
		});

		final Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t3 running");
			}
		});
		t2.start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		
		t3.start();
	}

}
