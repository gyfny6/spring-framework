package org.springframework.aop.aspectj.autoproxy.proxy.jdk;

public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("save user info");
	}

	@Override
	public void update() {
		System.out.println("update user info");
	}

}
