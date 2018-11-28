package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("java.io.tmpdir:"+System.getProperty("java.io.tmpdir"));
		System.out.println("net.sf.ehcache.enableShutdownHook:"+System.getProperty("net.sf.ehcache.enableShutdownHook"));
	}
}
