/**
 * 
 */
package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PatientInfoMapper;
import com.example.demo.model.PatientInfo;
import com.example.demo.model.PatientQuery;

/**
 * @author Ricki
 *
 */
@Service
public class PatientInfoService {

	@Autowired
	PatientInfoMapper patientInfoMapper;
	
	
	/**
	 * 查询病人列表数据
	 * @return
	 */
	public List<PatientInfo> queryList(Map<String,Object> paramMap){
		return patientInfoMapper.queryList(paramMap);
	}
	
	/**
	 * 查询病人信息的总记录数
	 * @param paramMap
	 * @return
	 */
	public int getTotalCount(Map<String,Object> paramMap) {
		return patientInfoMapper.getTotalCount(paramMap);
	}
	
	/**
	 * 根据查询条件查询病人列表
	 * @param paramMap
	 * @return
	 */
	public List<PatientInfo> queryPatientListByCondition(PatientQuery patientQuery){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//把patientQuery对象转为map
		if(patientQuery.getCheckStatus() != 0) {
			paramMap.put("checkStatus", patientQuery.getCheckStatus());
		}
		if(!"请选择".equals(patientQuery.getCareLevel().trim())) {
			paramMap.put("careLevel", patientQuery.getCareLevel());
		}
		
		if(!patientQuery.getPatientName().trim().equals("")) {
			paramMap.put("patientName", "%"+patientQuery.getPatientName()+"%");
		} 
		if(!patientQuery.getInHospitalNo().trim().equals("")) {
			paramMap.put("inHospitalNo", patientQuery.getInHospitalNo());
		}
		if(!patientQuery.getPatientType().trim().equals("")) {
			paramMap.put("patientType", patientQuery.getPatientType());
		}
		if(!patientQuery.getPatientDoctor().trim().equals("")) {
			paramMap.put("patientDoctor", patientQuery.getPatientDoctor());		
		}
		System.out.println(paramMap);
		return patientInfoMapper.queryPatientListByCondition(paramMap);
	}
	
	/**
	 * 根据ID删除病人信息
	 * @param id
	 */
	public void deletePatientById(Integer id) {
		patientInfoMapper.deletePatientById(id);
	}
	
	/**新增病人信息
	 * 
	 * @param paramMap
	 */
	public void addPitent(PatientInfo patientInfo) {
		patientInfoMapper.addPitent(patientInfo);
	}
	

}
