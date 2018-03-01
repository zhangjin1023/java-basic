package thread;

public class FlagExitThread extends Thread {
	public volatile boolean isExit = false;// 线程结束的标志

	public FlagExitThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (!isExit) {
			System.out.println("I'm running");
		}

	}

}
