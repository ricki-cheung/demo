/**
 * 
 */
package com.example.demo.shiro.config;

import org.apache.shiro.realm.Realm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.shiro.realm.HelixRealm;

/**
 * @author Ricki
 *
 */
@Configuration
public class ShiroIni {

	@Bean
	public Realm helixRealm() {
		return new HelixRealm();
	}
}
