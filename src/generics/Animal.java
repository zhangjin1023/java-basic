package generics;

public class Animal {
    private String name;

    public Animal() {
        // TODO Auto-generated constructor stub
    }

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(getName() + "can eat");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
