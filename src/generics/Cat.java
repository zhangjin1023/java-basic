package generics;

public class Cat extends Animal {
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name) {
		super(name);
	}

	public void jump() {
		System.out.println(getName() + "can jump");
	}

}
