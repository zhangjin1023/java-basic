package oop.laozhang;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月25日 下午10:05:27
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月25日 下午10:05:27
 */
public class Test {
    public static void main(String[] args) {
        Driver driver = new Driver("老张");
        driver.drive(new Car(), new Destination("东北"));

        driver.drive(new Plane(), new Destination("东北"));
    }

}
