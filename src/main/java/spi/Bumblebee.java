package spi;

/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 张锦
 * @date: 2019/4/21 13:43
 * @Copyright ©2019 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
