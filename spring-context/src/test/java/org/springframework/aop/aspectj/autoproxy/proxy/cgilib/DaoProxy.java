package org.springframework.aop.aspectj.autoproxy.proxy.cgilib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoProxy implements MethodInterceptor {

	/**
	 *
	 * @param object	进行增强的对象
	 * @param method	拦截的方法
	 * @param objects	拦截的对象
	 * @param proxy		方法的代理
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
		System.out.println("Before Method Invoke");
		proxy.invokeSuper(object, objects);//被代理对象的调用
		System.out.println("After Method Invoke");

		return object;
	}

}
