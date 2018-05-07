/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.PatientInfo;

/**
 * @author Ricki
 * mybatis的Mapper相当于Dao层
 */
@Mapper
public interface PatientInfoMapper {
	List<PatientInfo> queryList(Map<String,Object> paramMap);
	int getTotalCount(Map<String,Object> paramMap);
	List<PatientInfo>  queryPatientListByCondition(Map<String, Object> paramMap);
	void deletePatientById(Integer id);
	void addPitent(PatientInfo patientInfo);
}
