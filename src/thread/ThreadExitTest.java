package thread;

public class ThreadExitTest {
	public static void main(String[] args) {
		System.out.println("优雅的终止线程实例");

		//exitByFlag();
		exitByInterrupt();
	}

	private static void exitByFlag() {
		FlagExitThread flagExitThread = new FlagExitThread(FlagExitThread.class.getSimpleName());
		flagExitThread.start();

		try {
			Thread.sleep(3);
			flagExitThread.isExit = true;
			flagExitThread.join();
			System.out.println("线程退出");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void exitByInterrupt() {
		FlagExitThread flagExitThread = new FlagExitThread(FlagExitThread.class.getSimpleName());
		System.out.println("flagExitThread running...");
		flagExitThread.start();

		try {
			Thread.sleep(1500);
			System.out.println("flagExitThread interrupted...");
			flagExitThread.interrupt();
			Thread.sleep(1500);
			System.out.println("stop application...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
