package org.springframework.aop.aspectj.autoproxy.proxy.cgilib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class CglibTest {

	public static void main(String[] args) {
		test2();
	}

	public static void test1() {
		Enhancer enhancer = new Enhancer();
		//要代理的类
		enhancer.setSuperclass(Dao.class);
		//设置代理逻辑
		enhancer.setCallback(new DaoProxy());
		//生成代理对象
		Dao dao = (Dao)enhancer.create();//生成代理对象
		dao.update();
		dao.select();
	}

	public static void test2() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Dao.class);
		enhancer.setCallbacks(new Callback[]{new DaoProxy(), new DaoAnotherProxy(), NoOp.INSTANCE});
		enhancer.setCallbackFilter(new DaoFilter());
		enhancer.setInterceptDuringConstruction(false);//在构造函数中调用方法是否进行拦截


		Dao dao = (Dao)enhancer.create();
		dao.update();
		dao.select();
	}

}