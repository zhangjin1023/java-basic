package oop.laozhang;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月25日 下午9:58:51
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月25日 下午9:58:51
 */
public class Car extends Vehicle {

    /**
     * TODO
     *
     * @see oop.laozhang.Vehicle#go()
     */
    @Override
    void go(Destination dest) {
        System.out.println("汽车嘟嘟嘟去" + dest.getName());
    }

}
