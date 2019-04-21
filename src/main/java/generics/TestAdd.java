package generics;

import java.util.ArrayList;
import java.util.List;

public class TestAdd {
    public void testAdd(List<? extends Animal> list) {
        //编译不通过
        //list.add(new Animal());
        //list.add(new Cat());
        list.add(null);//不能往List<? extends Animal> 添加任意对象，除了null。

        for (Animal animal : list) {
            animal.eat();//可以调用方法
        }
    }

    public void testAdd2(List<? super Bird> list) {
        list.add(new Bird("bird1"));
        list.add(new Magpie("magpie1"));
    }

    public void testAdd3() {
        List<? super Bird> list = new ArrayList<>();
        list.add(new Bird("bird3"));
        list.add(new Magpie("magpie3"));
        //编译不通过，为了保护类型的一致性，因为“？ super Bird”可以是Animal，也可以是Object或其他Bird的父类，
        //因无法确定其类型，也就不能往List<? super Bird>添加Bird的任意父类对象。
        //list.add(new Animal("animal"));
    }


}
