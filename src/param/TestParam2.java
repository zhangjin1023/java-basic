/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2018年11月17日 上午12:35:40   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package param;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 * 
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年11月17日 上午12:35:40
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年11月17日 上午12:35:40
 */
public class TestParam2 {
    public static void main(String[] args) {
	// 测试Integer作为参数传递的时候，是否可以改变原对象的值
	Integer int1 = new Integer(0);
	testIntegerParam(int1);
	System.out.println("原对象地址" + int1.hashCode());
	System.out.println("原对象值=" + int1);
	// 结果：不可以改变原对象的值。因为Integer类是final修饰的的内部维护的是private final int value;

	// 测试String作为参数传递的时候，是否可以改变原对象的值
	String str1 = new String("aaa");
	testStringParam(str1);
	System.out.println("原对象地址" + str1.hashCode());
	System.out.println("原对象值=" + str1);
	// 结果：不可以改变原对象的值。因为String类是final修饰的的内部维护的是private final char value[];

	// 测试AtomicInteger作为参数传递的时候，是否可以改变原对象的值
	AtomicInteger atomicInt1 = new AtomicInteger(0);
	testAtomicIntegerParam(atomicInt1);
	System.out.println("原对象地址" + atomicInt1.hashCode());
	System.out.println("原对象值=" + atomicInt1);
	// 原对象的值被修改了。

    }

    /**
     * TODO
     * 
     * @param atomicInt1
     */
    private static void testAtomicIntegerParam(AtomicInteger atomicInt1) {
	atomicInt1.incrementAndGet();
	System.out.println("方法修改后地址" + atomicInt1.hashCode());
	System.out.println("方法修改后的值=" + atomicInt1);
    }

    /**
     * TODO
     * 
     * @param str1
     */
    private static void testStringParam(String str1) {
	str1 = "bbb";
	System.out.println("方法修改后地址" + str1.hashCode());
	System.out.println("方法修改后的值=" + str1);
    }

    /**
     * TODO
     * 
     * @param int1
     */
    private static void testIntegerParam(Integer int1) {
	int1++;
	System.out.println("方法修改后地址" + int1.hashCode());
	System.out.println("方法修改后的值=" + int1);
    }

}
