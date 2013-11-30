package com.pstel;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyTest implements BeanFactoryAware, InitializingBean, DisposableBean{

	
	public MyTest() {
		System.out.println("Hello world, Default constructor be invoked ...");
	}

	public void setId(int id) {
		System.out.println("Hello world, setter metohd invoke ...");
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Hello World, set Bean Factory");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello World, after properties");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Hello World, destory method invoke ...");
	}

}
