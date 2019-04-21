/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年8月20日 上午9:39:07
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆内存溢出
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年8月20日 上午9:39:07
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年8月20日 上午9:39:07
 */
public class MockOutOfMemory {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(new String("a"));
        }

    }

}
