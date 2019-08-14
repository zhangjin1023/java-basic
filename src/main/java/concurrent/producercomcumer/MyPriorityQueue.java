package concurrent.producercomcumer;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Date : 2019/8/14 19:35
 * @Author : zhang_jin
 */
public class MyPriorityQueue {
    //优先级阻塞队列
    private static PriorityBlockingQueue<Student> queue = new PriorityBlockingQueue<>();

    public static void main(String[] args) {
        //单个生产者线程
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Student student = new Student(new Random().nextInt(10), new Random().nextBoolean() ? "A" : "B", UUID.randomUUID().toString());
                System.out.println(student);
                queue.add(student);
            }
        }).start();

        //多个消费者线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        while (true) {
            if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getCorePoolSize()) {
                threadPoolExecutor.execute(new MyThread(queue));
            }
        }

    }

    public static class MyThread extends Thread {
        private PriorityBlockingQueue<Student> queue;

        public MyThread(PriorityBlockingQueue<Student> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 学生类，按照年龄从小到大排序。年龄相同的按照name从小到大排序。uuid便于识别
     * @description:
     * @Author zhang_jin
     * @Date
     **/
    public static class Student implements Comparable<Student> {
        private int age;
        private String name;
        private String id;

        public Student(int age, String name, String id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            int result = age > o.age ? 1 : (age == o.age ? 0 : -1);
            if (result == 0) {
                result = name.compareTo(o.name);
            }
            return result;
        }
    }
}
