package org.springframework.test.gyf.custemelement;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 将BeanDefinitionParser组件注册到Spring容器中
 * 注册标签解析器
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserDefinitionParser());
	}

}
