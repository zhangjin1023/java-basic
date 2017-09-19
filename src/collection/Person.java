package collection;

import java.util.Random;

public class Person {
    private int age;

    /**
     * TODO
     */
    public Person() {
        // TODO Auto-generated constructor stub
    }

    /**
     * TODO
     */
    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 只要年龄相等就认为是对象相等
     * 
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return p.getAge() == this.age;
        }
        return super.equals(obj);
    }

    /**
     * 故意让hashCode和equals返回值不一致，测试HashSet
     * 
     * @return
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        Random r = new Random();
        return r.nextInt(100);
        // 如果注释掉上面的随机返回值，而是用固定返回值，只要年龄相等，则无法重复加入HashSet
//         return 1;
    }

}
