/**
 * All rights Reserved, Designed By XXXCompany.
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年8月20日 上午9:34:39
 * @Copyright ©2017 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package jvm;

/**
 * Exception in thread "main" java.lang.StackOverflowError
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年8月20日 上午9:34:39
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@XXXCompany.com]/2017年8月20日 上午9:34:39
 */
public class MockStackOverFlow {
    public static void main(String[] args) {
        while (true) {//无限循环递归调用，模拟StackOverflowError
            test();
        }
    }

    public static void test() {
        test();
    }

}
