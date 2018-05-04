package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ricki
 *
 */
@Controller
public class IndexController {
	
	/*@Autowired
	private MenuTreeService menuTreeService;*/

	/**
	 * @return
	 * 登录成功后的首页页面
	 */
	@RequestMapping("/index")
	public String indexPage(Model model,@RequestParam(defaultValue="1") Integer id) {
		//JSONArray allJsonArray = menuTreeService.getMenu(id);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		model.addAttribute("treeMenu", session.getAttribute("treeMenu"));
		return "index";
	}
	
	
	

	
}
