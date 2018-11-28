/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.PatientInfo;
import com.example.demo.model.PatientQuery;
import com.example.demo.model.Person;
import com.example.demo.service.PatientInfoService;

/**
 * @author Ricki
 *
 */
@Controller
public class PatientInfoContoller {
	
	@Autowired
	PatientInfoService patientInfoService;
	
	@RequestMapping("/patientInfo")
	public ModelAndView list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="15") int pageSize){
		//获取表中所有记录数 
		int totalCnt = patientInfoService.getTotalCount(null);
		//计算页数
		int pageCnt=(totalCnt+pageSize-1)/pageSize;
		
		if(pageNo>=pageCnt) {
			pageNo = pageCnt;
		}
		if(pageNo<=1) {
			pageNo = 1;
		}
	    //计算查询的记录起始位置
		int offset = (pageNo - 1)*pageSize;
	
		//定义传参数据
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("offset", offset);
		paramMap.put("pageSize", pageSize);
		
		//获取分页数据
		List<PatientInfo> resultList = patientInfoService.queryList(paramMap);
		ModelAndView modelAndView = new ModelAndView("patientList");    
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("pageNo",pageNo);
		modelAndView.addObject("pageSize",pageSize);
		modelAndView.addObject("totalCnt",totalCnt);
		modelAndView.addObject("pageCnt",pageCnt);
		return modelAndView;
	}
	
	@RequestMapping("/pagePientList")//请求重定向，更新数据
	public String pagePientList(@RequestParam int pageNo,@RequestParam int pageSize,RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("pageNo",pageNo);
		redirectAttributes.addAttribute("pageSize",pageSize);
		 return "redirect:/patientInfo";
	}
	
	@RequestMapping("/queryPatientInfo")
	public String queryPatientInfo(Model model,PatientQuery patientQuery) {
		List<PatientInfo> patientInfoList = patientInfoService.queryPatientListByCondition(patientQuery);
		int pageCnt=( patientInfoList.size()+patientQuery.getPageSize()-1)/patientQuery.getPageSize();
		model.addAttribute("resultList",patientInfoList);
		model.addAttribute("pageNo", 1);
		model.addAttribute("pageSize", patientQuery.getPageSize());
		model.addAttribute("totalCnt", patientInfoList.size());
		model.addAttribute("pageCnt", pageCnt);
		return "patientList";
	}
	
	
	/**
	 * 根据ID删除病人信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletePatientById")
	public String deletePatientById(@RequestParam Integer id) {
		patientInfoService.deletePatientById(id);
		return "redirect:/patientInfo";
	}
	
	
	@RequestMapping("/toPatientAdd")
	public String patientAdd() {
		return "/addoredit/patientAddOrEdit";
	}
	
	/**
	 * 新增病人信息
	 * @param patientInfo
	 * @return
	 */
	@RequestMapping("/addPaitentInfo")
	public String addPaitentInfo(PatientInfo patientInfo) {
		Person person = patientInfoService.queryPersonforName(patientInfo.getName());
		patientInfoService.addPaitentInfo(patientInfo, person);
		/*if(person != null) {
			patientInfo.setId(person.getPersonSn());
		}else {
			patientInfoService.addPerson(patientInfo.getName());//新增person
			person = patientInfoService.queryPersonforName(patientInfo.getName());
			patientInfo.setId(person.getPersonSn());	
		}
		patientInfoService.addPatient(patientInfo);//新增patient
*/		return "redirect:/patientInfo";
	}
	
	/**
	 * 修改病人信息
	 * @param patientInfo
	 * @return
	 */
	@RequestMapping("/updatePaitentInfo")
	public String updatePaitentInfo(PatientInfo patientInfo) {
		Integer id = patientInfo.getId();
		String name = patientInfo.getName();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("name", name);
		paramMap.put("id", id);
		/*
		patientInfoService.updatePerson(paramMap);//修改name
		patientInfoService.updatePatientInfo(patientInfo);//修改其他*/
		
		patientInfoService.updatePaitentInfo(patientInfo, paramMap);
		return "redirect:/patientInfo";
		
	}
	
}
