package concurrent.threadlocal;

import java.util.Random;

public class ThreadLocalDemo implements Runnable {
    private final static ThreadLocal<Student> studentLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        Thread a = new Thread(threadLocalDemo, "a");
        Thread b = new Thread(threadLocalDemo, "b");

        a.start();
        b.start();
    }

    @Override
    public void run() {
        accessStudent();
    }

    private void accessStudent() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running");

        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread " + currentThreadName + " set age to " + age);
        Student student = getStudent();
        student.setAge(age);

        System.out.println("thread " + currentThreadName + " first read age is " + student.getAge());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("thread " + currentThreadName + " second read age is " + student.getAge());

    }

    protected Student getStudent() {
        Student student = studentLocal.get();
        if (student == null) {
            student = new Student();
            studentLocal.set(student);
        }
        return student;
    }

}
