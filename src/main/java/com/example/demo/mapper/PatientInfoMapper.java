/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.PatientInfo;

/**
 * @author Ricki
 *
 */
@Mapper
public interface PatientInfoMapper {

	List<PatientInfo> queryList();
}
