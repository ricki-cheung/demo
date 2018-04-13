/**
 * 
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ricki
 *
 */
@Controller
public class IndexController {

	/**
	 * @return
	 * 登录成功后的首页页面
	 */
	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}
}
