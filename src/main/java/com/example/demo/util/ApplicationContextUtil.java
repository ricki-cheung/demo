/**
 * 
 */
package com.example.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Ricki
 *
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtil.applicationContext = applicationContext;
	}
	
	/**
	 * 根据名称获取bean实例
	 * @param beanName
	 * @return
	 */
	public static <T> T getBean(String beanName,Class<T> requireType) {
		if(applicationContext == null) return null;
		T result = null;
		try {
			result = applicationContext.getBean(beanName,requireType);
		}catch(Exception e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

}
