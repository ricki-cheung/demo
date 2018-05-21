/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.PatientInfo;
import com.example.demo.service.PatientInfoService;

import net.sf.json.JSONObject;

/**
 * @author yanzhiying
 *
 */
@Controller
public class PatientInfoContoller2 {
	
	@Autowired
	PatientInfoService patientInfoService;
	
	@RequestMapping("/getPatientInfo")
	@ResponseBody
	public List<PatientInfo> list(
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
		return resultList;
	}
	
	@RequestMapping("/patientInfo2")
	public String patientList() {
		return "/patientList2";
	}
	
	/**
	 * 删除病人信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/patientInfoAjax")
	@ResponseBody
	public Map<String,Object> testAjax(Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		if(id != null) {
				//patientInfoService.deletePatientById(id);
				map.put("result", 1);
		}else {
			map.put("result", 0);
		}
		return map;
	}
	
	
	
	
	
	
	
}
