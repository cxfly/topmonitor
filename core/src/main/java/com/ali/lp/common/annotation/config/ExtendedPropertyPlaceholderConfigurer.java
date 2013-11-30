/**
* @{#} ExtendedPropertyPlaceholderConfigurer.java Created on 2010-8-16 下午11:06:27
*
* Copyright (c) 2010 by ZHONGBO software.
*/
package com.ali.lp.common.annotation.config;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author <a href="mailto:lizhe2@asiainfo-linkage.com">lizhe</a>
 * @version 1.0
 */
public class ExtendedPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	
	private Properties props;
	
	@Override
	protected void processProperties(
	      ConfigurableListableBeanFactory beanFactory, Properties props)
	      throws BeansException {
	   super.processProperties(beanFactory, props);
	   this.props = props;
	}

	public Object getProperty(String key) {
	   return props.get(key);
	}

}
