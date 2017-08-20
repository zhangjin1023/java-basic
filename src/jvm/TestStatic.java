/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2017年8月18日 上午12:27:42   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package jvm;

/**  
 * TODO
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年8月18日 上午12:27:42
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年8月18日 上午12:27:42
 */
public class TestStatic {
    public static void main(String[] args) {
        System.out.println(LoadClass.a);
        System.out.println(LoadClass.b);
        
    }
    

}

class LoadClass{
    private static LoadClass instance = new LoadClass();
    private static final String s = "hello";//static final 修饰的变量==》常量，必须显式的初始化。
    private final String t = "world";//final 修饰的成员变量 必须显式的初始化。
    public static int a;//可以不进行初始化，类加载的"准备阶段"会赋默认值（根据类型不同默认值不同）
    public static int b=123;
    
    static{
        a++;
        b++;
    }
    private LoadClass(){
        a++;
        b++;
    }
}
