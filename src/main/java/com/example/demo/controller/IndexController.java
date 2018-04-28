package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.MenuTreeService;

import net.sf.json.JSONArray;

/**
 * @author Ricki
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	private MenuTreeService menuTreeService;

	/**
	 * @return
	 * 登录成功后的首页页面
	 */
	@RequestMapping("/index")
	public String indexPage(Model model,@RequestParam(defaultValue="1") Integer id) {
		JSONArray allJsonArray = menuTreeService.getMenu(id);
		model.addAttribute("treeMenu", allJsonArray);
		return "index";
	}
	
	
	

	
}
