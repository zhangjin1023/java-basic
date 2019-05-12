package oop.laozhang;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年9月25日 下午10:15:46
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@XXXCompany.com]/2017年9月25日 下午10:15:46
 */
public class Plane extends Vehicle {

    /**
     * TODO
     *
     * @param dest
     * @see oop.laozhang.Vehicle#go(oop.laozhang.Destination)
     */
    @Override
    void go(Destination dest) {
        System.out.println("飞机嗖嗖嗖去" + dest.getName());
    }

}
