package selftest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import selftest.aop.Dao;

public class AopTest {

	@Test
	public void testAop() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("selftest/aop.xml");

		Dao dao = (Dao)ac.getBean("daoImpl");
		dao.select();
	}

}
