/**
 * 
 */
package com.example.demo.shiro.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.shiro.realm.HelixRealm;

/**
 * @author Ricki
 *
 */
@Configuration
public class ShiroBaseConfiguration {

	/**
	 * @return
	 * 配置Helix数据库用户角色权限处理对象
	 */
	@Bean
	public Realm helixRealm() {
		return new HelixRealm();
	}
	
	
	/**
	 * @return
	 * 定义shiro.ini中的url
	 */
	@Bean
    protected ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "authc");
        chainDefinition.addPathDefinition("/logout", "logout");
        return chainDefinition;
    }
}
