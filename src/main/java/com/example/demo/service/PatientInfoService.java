/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PatientInfoMapper;
import com.example.demo.model.PatientInfo;

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
	

}
