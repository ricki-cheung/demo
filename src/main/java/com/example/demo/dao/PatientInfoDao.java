/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.mapper.PatientInfoMapper;
import com.example.demo.model.PatientInfo;

/**
 * @author Ricki
 *
 */
@Component
public class PatientInfoDao {
	
	private final PatientInfoMapper patientInfoMapper;
	
    /**
     * 构造函数会自动注入参数所需要的bean
     * @param patientInfoMapper
     */
    public PatientInfoDao(PatientInfoMapper patientInfoMapper) {
    	this.patientInfoMapper = patientInfoMapper;
    }
    
    public List<PatientInfo> queryList() {
    	return patientInfoMapper.queryList();
    }

}
