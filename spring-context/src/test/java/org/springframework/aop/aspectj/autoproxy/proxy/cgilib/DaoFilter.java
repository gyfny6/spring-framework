package org.springframework.aop.aspectj.autoproxy.proxy.cgilib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class DaoFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		//return "select".equals(method.getName()) ? 0 : 1;
		//return 2;
		return 1;
	}

}
