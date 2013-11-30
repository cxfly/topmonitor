package com.ali.lp.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * 用于动态加载bean
 * 
 * @author lz
 * 
 */
@Service("busiBeanAdapter")
public class BeanAdapter implements BeanFactoryAware {
	protected BeanFactory beanFactory;

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		this.beanFactory = arg0;
	}

	/**
	 * 动态获取一个Bean
	 * 
	 * @param beanName
	 * @return
	 * @throws Exception
	 */
	public Object getBean(String beanName) throws Exception {
		return beanFactory.getBean(beanName);
	}

}
