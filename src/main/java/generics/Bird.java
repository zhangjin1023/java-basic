package generics;

public class Bird extends Animal {
    public Bird() {
        // TODO Auto-generated constructor stub
    }

    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(getName() + "can fly");
    }

}
