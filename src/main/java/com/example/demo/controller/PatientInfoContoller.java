/**
 * 
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PatientInfo;

/**
 * @author Ricki
 *
 */
@RestController
public class PatientInfoContoller {

	@RequestMapping("/patients")
	public List<PatientInfo> list(){
		List<PatientInfo> resultList = new ArrayList<PatientInfo>();
		
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setId(1l);
		patientInfo.setCareLevel("一级护理");
		patientInfo.setName("张三");
		
		resultList.add(patientInfo);
		
		return resultList;
	}
}
