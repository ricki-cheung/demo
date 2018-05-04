/**
 * 
 */
package com.example.demo.shiro.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.config.web.autoconfigure.ShiroWebFilterConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.shiro.filter.MyAuthenticationFilter;

/**
 * @author Ricki
 *
 */
@Configuration
@ConditionalOnProperty(name = "shiro.web.enabled", matchIfMissing = true)
public class ShiroBaseFilterConfiguration extends ShiroWebFilterConfiguration {

	@Bean
	@Override
	protected ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = super.shiroFilterFactoryBean();
		Map<String,Filter> filterMap = new HashMap<String,Filter>();
		filterMap.put("authc", new MyAuthenticationFilter());
		shiroFilterFactoryBean.setFilters(filterMap);
		return shiroFilterFactoryBean;
	}

	
}
