/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年7月15日 下午4:27:12
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package param;

/**
 * 测试java参数传递：都是按值传递
 *
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年7月15日 下午4:27:12
 * @version: V1.0
 * @review: zhangjin[zhang_jin@suixingpay.com]/2017年7月15日 下午4:27:12
 */
public class TestParam {
    public static void method1(int i) {
        i = i + 1;
        System.out.println(i);
    }

    public static void method2(Person p) {
        p = new Person();
        p.setName("新人");
        p.setAge(66);
        System.out.println("修改之后的引用" + p);
    }

    public static void main(String[] args) {
        int x = 5;
        method1(5);
        System.out.println(x);

        Person oldPerson = new Person();
        oldPerson.setAge(10);
        oldPerson.setName("老人");
        System.out.println("修改之前的引用" + oldPerson);

        method2(oldPerson);
        System.out.println("原来的引用" + oldPerson);
    }

}

class Person {
    private String name;
    private int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

}
