/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年9月10日 下午1:10:01
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 * @author: zhangjin[zhang_jin@suixingpay.com]
 * @date: 2017年9月10日 下午1:10:01
 * @version: V1.0
 * @review: zhangjin[zhang_jin@suixingpay.com]/2017年9月10日 下午1:10:01
 */
public class TestAtomicInteger {
    public static void main(String[] args) {
        //创建,获取值
        AtomicInteger ai = new AtomicInteger(123);
        System.out.println(ai.get());

        //比较并设置
        int expect = 123;
        int update = 456;
        System.out.println(ai.compareAndSet(expect, update));//返回boolean值
        System.out.println(ai.get());

        //增加值
        System.out.println(ai.getAndAdd(2));
        System.out.println(ai.addAndGet(2));

        //原子性的 ++i，i++
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.incrementAndGet());
    }

}
