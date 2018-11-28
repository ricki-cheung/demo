/**
 * 
 */
package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.PatientInfoMapper;
import com.example.demo.model.PatientInfo;
import com.example.demo.model.PatientQuery;
import com.example.demo.model.Person;

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
	public void addPatient(PatientInfo patientInfo) {
		patientInfoMapper.addPatient(patientInfo);
	}
	
	/**
	 * 修改病人信息
	 * @param patientInfo
	 */
	public void updatePatientInfo(PatientInfo patientInfo) {
		patientInfoMapper.updatePatientInfo(patientInfo);
	}
	
	/**
	 * 根据名字查询病人流水号
	 * @param name
	 * @return
	 */
	public Person queryPersonforName(String name) {
		return patientInfoMapper.queryPersonforName(name);
	}
	
	/**
	 * 新增person
	 * @param name
	 */
	public void addPerson(String name) {
		patientInfoMapper.addPerson(name);
	}
	
	/**
	 * 修改person名字
	 * @param paramMap
	 */
	public void updatePerson(Map<String, Object> paramMap) {
		patientInfoMapper.updatePerson(paramMap);
	}
	
	/**
	 * 新增patientInfo
	 * @param patientInfo
	 * @param person
	 * @param personService
	 * 
	 */
	//@Transactional
	public void addPaitentInfo(PatientInfo patientInfo,Person person) {
		if(person != null) {
			patientInfo.setId(person.getPersonSn());
		}else {
			addPerson(patientInfo.getName());//新增person
			person = queryPersonforName(patientInfo.getName());
			patientInfo.setId(person.getPersonSn());	
		}
		addPatient(patientInfo);//新增patient
	}
	

	/**
	 * 修改病人信息
	 * @param patientInfo
	 * @return
	 */
	//@Transactional
	public void updatePaitentInfo(PatientInfo patientInfo,Map<String,Object> paramMap) {
		updatePerson(paramMap);//修改name
		updatePatientInfo(patientInfo);//修改其他
	}
}
