package concurrent.threadcontrol;

/**
 * @description:捕获子线程的异常
 * @Date : 2019/12/12 11:25
 * @Author : zhang_jin
 */
public class CatchException {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> Integer.parseInt("aaa"));
//        MyThreadExcptionHandler excptionHandler = new MyThreadExcptionHandler();
//        thread.setUncaughtExceptionHandler(excptionHandler);
        thread.start();

        System.out.println("开始睡眠");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束睡眠");
    }

}

class MyThreadExcptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("异常被捕获了");
    }
}