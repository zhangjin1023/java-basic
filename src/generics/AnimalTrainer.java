package generics;

import java.util.List;

public class AnimalTrainer {
	// Test1 无通配符
	// public void act(List<Animal> list) {
	// for (Animal animal : list) {
	// animal.eat();
	// }
	//
	// }

	// Test2 通配符上界
	public void act(List<? extends Animal> list) {
		for (Animal animal : list) {
			animal.eat();
		}

	}

}
