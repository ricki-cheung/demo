/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.PatientInfo;
import com.example.demo.service.PatientInfoService;

/**
 * @author Ricki
 *
 */
@Controller
public class PatientInfoContoller {
	
	@Autowired
	PatientInfoService patientInfoService;

	/*@RequestMapping("/patientList")
	public String patientList(ModelMap modelMap,HttpServletRequest request){
		modelMap.put("patientList", "patientList");
		return "/dateList";
	}*/
	
	
	@RequestMapping("/patientInfo")
	public ModelAndView list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="20") int pageSize){
		//获取表中所有记录数 
		int totalCnt = patientInfoService.getTotalCount(null);
		//计算页数
		int pageCnt=(totalCnt+pageSize-1)/pageSize;
	    //计算查询的记录起始位置
		int offset = (pageNo - 1)*pageSize;
		System.out.println("22222222222222222222222222");
		//定义传参数据
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("offset", offset);
		paramMap.put("pageSize", pageSize);
		
		//获取分页数据
		List<PatientInfo> resultList = patientInfoService.queryList(paramMap);
		ModelAndView modelAndView = new ModelAndView("patientInfo");    
		modelAndView.addObject("resultList", resultList);
		return modelAndView;
	}
	
	
}
