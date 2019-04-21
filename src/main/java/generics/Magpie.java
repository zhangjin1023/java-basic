package generics;

public class Magpie extends Bird {
    public Magpie() {
        // TODO Auto-generated constructor stub
    }

    public Magpie(String name) {
        super(name);
    }

    public void sing() {
        System.out.println(getName() + "can not only eat,but sing");
    }

}
