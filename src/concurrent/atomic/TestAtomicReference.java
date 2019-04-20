package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子更新引用类型
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
public class TestAtomicReference {
    public static AtomicReference<User> ar = new AtomicReference<>();

    public static void main(String[] args) {
        User user1 = new User("conan", 15);
        ar.set(user1);
        System.out.println(ar.get().getName() + "," + ar.get().getAge());
        User newUser = new User("ran", 18);
        ar.compareAndSet(user1, newUser);
        System.out.println(ar.get().getName() + "," + ar.get().getAge());
    }

    static class User {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

}
