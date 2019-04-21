/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年8月17日 下午4:45:19
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package sort;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

/**
 * 拼音
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年8月17日 下午4:45:19
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年8月17日 下午4:45:19
 */
public class Pinyin {
    public static void main(String[] args) {
        String[] names = {"张锦", "李乐勇", "河源", "李秋雨"};
        Arrays.sort(names, Collator.getInstance(Locale.CHINA));
        for (String str : names) {
            System.out.println(str);
        }

    }

}
