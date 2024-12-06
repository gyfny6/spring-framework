package org.springframework.test.gyf.custemelement;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Parser类
 * 解析XSD文件中的定义和组件定义。
 */
public class UserDefinitionParser extends AbstractSingleBeanDefinitionParser {

	private static final Map<String, String> ATTRIBUTE_VALUE = new HashMap<String, String>();

	static {
		ATTRIBUTE_VALUE.put("id", "id");
		ATTRIBUTE_VALUE.put("userName", "userName");
		ATTRIBUTE_VALUE.put("email", "email");
	}

	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		ATTRIBUTE_VALUE.forEach(
				(propertyName,attributeName)
						-> builder.addPropertyValue(propertyName, element.getAttribute(attributeName)));

	}

}