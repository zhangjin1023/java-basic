package cglib_dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CarInterceptor implements MethodInterceptor {
	// 持有被代理对象
	private Object tartget;

	//回调方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("start......");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("end......");
		return result;
	}

	public Object getproxyInstance(Object target) {
		this.tartget = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.tartget.getClass());
		enhancer.setCallback(this);
		// 创建代理对象，并返回
		return enhancer.create();
	}
}
