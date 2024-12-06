/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.config;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.SAXParseException;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import selftest.BeanPostProcessorTest;
import selftest.MyApplicationAware;

import static org.junit.Assert.*;

/**
 * @author Adrian Colyer
 * @author Chris Beams
 */
public class AopNamespaceHandlerAdviceTypeTests {

	@Test
	public void test() {
		System.out.println("====================");
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/springframework/aop/config/spring.xml");
		//applicationContext.getBean(BeanPostProcessorTest.class);

		ClassPathResource resource = new ClassPathResource("spring.xml",getClass());
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

		factory.addBeanPostProcessor(new BeanPostProcessorTest());
		reader.loadBeanDefinitions(resource);

		System.out.println(factory.getBean(BeanPostProcessorTest.class));

		//MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		//applicationAware.display();
		System.out.println("====================");
	}

	@Test
	public void testParsingOfAdviceTypes() {
		new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-ok.xml", getClass());
	}

	@Test
	public void testParsingOfAdviceTypesWithError() {
		try {
		new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-error.xml", getClass());
			fail("Expected BeanDefinitionStoreException");
		}
		catch (BeanDefinitionStoreException ex) {
			assertTrue(ex.contains(SAXParseException.class));
		}
	}

}
