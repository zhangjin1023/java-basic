package generics;

import java.util.ArrayList;
import java.util.List;

public class TestAnimal {
    public static void main(String[] args) {
        AnimalTrainer animalTrainer = new AnimalTrainer();
        // Test1
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Cat("cat1"));
        animalList.add(new Bird("bird1"));

        animalTrainer.act(animalList);

        //Test2
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("cat2"));
        catList.add(new Cat("cat3"));
        //编译不通过，因为List<Cat>并不是List<Animal>子类
        animalTrainer.act(catList);
    }

}
