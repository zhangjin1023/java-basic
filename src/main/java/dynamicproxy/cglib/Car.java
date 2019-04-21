package dynamicproxy.cglib;

/**
 * 不实现接口，采用cglib方式实现动态代理
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
public class Car {
    void move() {
        System.out.println("汽车 嘟嘟嘟 开跑了");
    }

}
