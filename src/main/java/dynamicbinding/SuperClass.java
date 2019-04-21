/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年9月10日 下午9:31:39
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package dynamicbinding;

/**
 * 测试静态绑定和动态绑定
 * 1.成员变量，静态方法，私有方法，被final修饰的方法 都是静态绑定。
 * 2.静态方法不能被重写
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年9月10日 下午9:31:39
 * @version: V1.0
 * @review: zhangjin[zhang_jin@suixingpay.com]/2017年9月10日 下午9:31:39
 */
public class SuperClass {
    // 成员变量
    public String name = "zhangsan";
    public int i = 0;

    // 静态方法
    public static void staticMethod() {
        System.out.println("super static method");
    }

    // 非静态方法
    public void method() {
        System.out.println("super method");
    }

}
