package com.ali.lp.common.spring;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 
 * @author lz
 *
 */
@Service("springBeanUtils")
public class SpringBeanUtils {
	
	private static BeanAdapter beanAdapter;

	public static Object getBean(String name) throws Exception {
		return beanAdapter.getBean(name);
	}

	/**
	 * 设置beanAdapter 到 beanAdapter
	 * @param beanAdapter
	 */
	@Resource(name="busiBeanAdapter")
	public void setBeanAdapter(BeanAdapter beanAdapter) {
		SpringBeanUtils.beanAdapter = beanAdapter;
	}
}
