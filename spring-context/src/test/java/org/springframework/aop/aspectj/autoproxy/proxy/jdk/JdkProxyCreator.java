package org.springframework.aop.aspectj.autoproxy.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyCreator implements ProxyCreator, InvocationHandler {

	private Object target;

	public JdkProxyCreator(Object target) {
		assert target != null;
		Class<?>[] interfaces = target.getClass().getInterfaces();
		if (interfaces.length == 0) {
			throw new IllegalArgumentException("target class don`t implement any interface");
		}
		this.target = target;
	}

	@Override
	public Object getProxy() {
		Class<?> clazz = target.getClass();
		// 生成代理对象
		//当调用代理对象的方法时，会调用InvocationHandler.invoke()
		//JDK代理只能代理实现了接口的对象
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this/*调用处理器*/);
	}

	//调用处理器InvocationHandler的处理逻辑
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method start");
		// 调用目标方法
		Object retVal = method.invoke(target, args);
		System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method over");

		return retVal;
	}
}
