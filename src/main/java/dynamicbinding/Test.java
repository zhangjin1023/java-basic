/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年9月10日 下午9:39:05
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package dynamicbinding;

/**
 * TODO
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年9月10日 下午9:39:05
 * @version: V1.0
 * @review: zhangjin[zhang_jin@suixingpay.com]/2017年9月10日 下午9:39:05
 */
public class Test {

    public static void main(String[] args) {
        //成员变量，静态绑定，所以是声明的类型SuperClass的成员变量
        SuperClass sub = new SubClass();
        System.out.println(sub.name);
        System.out.println(sub.i);

        SubClass sub2 = new SubClass();
        System.out.println(sub2.i);

    }
}
