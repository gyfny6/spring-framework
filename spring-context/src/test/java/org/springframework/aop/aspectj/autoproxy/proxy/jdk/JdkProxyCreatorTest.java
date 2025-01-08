package org.springframework.aop.aspectj.autoproxy.proxy.jdk;

public class JdkProxyCreatorTest {

	public static void main(String[] args) {
		ProxyCreator proxyCreator = new JdkProxyCreator(new UserServiceImpl());
		UserService userService = (UserService) proxyCreator.getProxy();

		System.out.println("proxy type = " + userService.getClass());
		System.out.println();
		userService.save();
		System.out.println();
		userService.update();
	}

}
