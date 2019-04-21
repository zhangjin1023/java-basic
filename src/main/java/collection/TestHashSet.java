package collection;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        Person person1 = new Person(18);
        Person person2 = new Person(18);
        Person person3 = new Person(19);
        System.out.println(person1.equals(person2));
        System.out.println("person1 hashCode:" + person1.hashCode());
        System.out.println("person2 hashCode:" + person2.hashCode());
        System.out.println("person3 hashCode:" + person3.hashCode());

        Set<Person> hashSet = new HashSet<>();
        hashSet.add(person1);
        hashSet.add(person2);
        hashSet.add(person3);
        System.out.println(hashSet.size());

    }

}
