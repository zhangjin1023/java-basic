/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2017年8月17日 下午5:44:33   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package string;

import java.lang.reflect.Field;

/**
 * 利用反射，修改String
 * 
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年8月17日 下午5:44:33
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年8月17日 下午5:44:33
 */
public class ModifyString {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        String s = "Hello World";
        System.out.println("s=" + s);

        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        char[] value = (char[]) valueField.get(s);
        value[5] = '_';

        System.out.println("s=" + s);
    }

}
