/**
 * 
 */
package com.example.demo.config.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.realm.HelixRealm;

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
	 * 如果设置了sessionDAO，相应需要配置cacheManager
	 */
	@Bean
	public CacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		//TODO 只是把classpath:org/apache/shiro/cache/ehcache/ehcache.xml默认的diskPersistent改为false
		cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return cacheManager;
	}
	
	/**
	 * @return
	 * 设置sessionDAO,默认是MemorySessionDAO
	 */
	@Bean
	public SessionDAO sessionDAO() {
        return new EnterpriseCacheSessionDAO();
    }
	
	/**
	 * @return
	 * 定义shiro.ini中的url
	 */
	@Bean
    protected ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
		chainDefinition.addPathDefinition("/logout", "logout");
		chainDefinition.addPathDefinition("/static/**", "anon");
		chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }
	
	
}
