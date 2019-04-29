package reflect;

import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 张锦
 * @date: 2019/4/29 22:58
 * @Copyright ©2019 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class ReflectTest {

    /**
     * 蚂蚁金服笔试题：通过反射调用对象某个方法，包括私有方法
     *
     * @return void
     * @Author zhang_jin@suixingpay.com
     * @Date 23:16 2019/4/29
     * @Param [target, methodName, param]
     **/
    public static void reflectMethodInvoke(Object target, String methodName, Object param) throws Exception {
        Method method = target.getClass().getDeclaredMethod(methodName, new Class[]{param.getClass()});
        method.setAccessible(true);
        Object result = method.invoke(target, param);
        System.out.println(result);
    }

    public static void main(String[] args) {
        try {
            reflectMethodInvoke(new ReflectTest(), "sayHello", "world");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String sayHello(String args) {
        return "hello " + args;
    }

}
