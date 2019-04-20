package oop.laozhang;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月25日 下午9:56:23
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月25日 下午9:56:23
 */
public class Driver {
    private String name;

    /**
     * TODO
     */
    public Driver(String name) {
        this.name = name;
    }

    public void drive(Vehicle v, Destination dest) {
        System.out.print(this.name + "开着");
        v.go(dest);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
