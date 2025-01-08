package org.springframework.aop.aspectj.autoproxy.proxy.cgilib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoAnotherProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
		System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
		proxy.invokeSuper(object, objects);//被代理对象的调用
		System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
		return object;



	}

}
