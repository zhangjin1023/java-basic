package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/**
 * 原子更新字段类都是抽象类，每次使用都时候必须使用静态方法newUpdater创建一个更新器。
 * 原子更新类的字段的必须使用public volatile修饰符。
 * @author zhang_jin[zhang_jin@suixingpay.com]
 *
 */
public class TestAtomicIntegerFieldUpdater {

	private static AtomicIntegerFieldUpdater<User> aif = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
	public static void main(String[] args) {
		User user = new User("conan",10);
		System.out.println(aif.getAndIncrement(user));
		System.out.println(aif.get(user));
	}

	public static class User {
		private String name;
		public volatile int age;

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

		public User(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public User() {
			super();
		}

	}

}
