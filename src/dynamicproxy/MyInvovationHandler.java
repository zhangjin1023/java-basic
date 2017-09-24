/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2017年9月24日 下午1:03:14   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 * 
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月24日 下午1:03:14
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月24日 下午1:03:14
 */
public class MyInvovationHandler implements InvocationHandler {

    // 关联一个被代理对象,传入接口类型即可
    Moveable moveable;

    /**
     * 构造器中传入该被代理对象
     */
    public MyInvovationHandler(Moveable moveable) {
        this.moveable = moveable;
    }

    /**
     * TODO
     * 
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
     *      java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start......");
        Object invoke = method.invoke(moveable, args);
        System.out.println("end......");
        return invoke;
    }

    public Moveable getProxyInstance() {
        return (Moveable) Proxy.newProxyInstance(Moveable.class.getClassLoader(), new Class[] { Moveable.class }, this);
    }

}
