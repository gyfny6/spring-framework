package selftest.aop;

import org.springframework.aop.framework.AopContext;

public class DaoImpl implements Dao {

	@Override
	public void select() {
		System.out.println("Enter DaoImpl.select()");
		//写法1：insert()上面的切面逻辑不会执行
		//this.insert();

		//写法2：insert()上面的切面逻辑会执行。
		//AopContext.currentProxy()获取当前的代理对象，expose-proxy=true时该对象会被放入到ThreadLocal中
		((Dao)AopContext.currentProxy()).insert();
	}

	@Override
	public void insert() {
		System.out.println("Enter DaoImpl.insert()");
	}

}
