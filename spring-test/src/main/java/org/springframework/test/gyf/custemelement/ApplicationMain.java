package org.springframework.test.gyf.custemelement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
	}
}
