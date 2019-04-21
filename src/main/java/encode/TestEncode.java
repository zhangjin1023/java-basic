/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年1月28日 下午10:19:16
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package encode;

import java.io.IOException;

/**
 * 各种编码解码
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年1月28日 下午10:19:16
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年1月28日 下午10:19:16
 */
public class TestEncode {
    public static void main(String[] args) throws IOException {
        String str1 = "I am ZhangJin";
        String str2 = "我是张锦";

        System.out.println("str1 字符串长度为:" + str1.toCharArray().length);
        System.out.println("str1 GBK编码后的字节数组长度为:" + str1.getBytes("GBK").length);

        System.out.println("str2 字符串长度为:" + str2.toCharArray().length);
        System.out.println("str2 GBK编码后的字节数组长度为:" + str2.getBytes("GBK").length);
        //////////////////////////////////
        System.out.println("str1 字符串长度为:" + str1.toCharArray().length);
        System.out.println("str1 UTF-8编码后的字节数组长度为:" + str1.getBytes("UTF-8").length);

        System.out.println("str2 字符串长度为:" + str2.toCharArray().length);
        System.out.println("str2 UTF-8编码后的字节数组长度为:" + str2.getBytes("UTF-8").length);
    }

}
