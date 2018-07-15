package thread;

/*
 * 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行  
 * 
 * 
 */
public class ThreadControl2 {

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
				System.out.println("t2 running");
			}
		});

		final Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t3 running");
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
