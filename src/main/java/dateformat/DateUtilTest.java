package dateformat;

public class DateUtilTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new TestThreadSafe().start();
        }
    }

    public static class TestThreadSafe extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    this.join(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println(this.getName() + ":" + DateUtil3.parse("2013-05-24 06:02:20"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
