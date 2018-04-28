/**
 * 
 */
package com.example.demo.model;

/**
 * @author Ricki
 *
 */
public class PatientInfo {

	private Long id;
	private String name;
	private String careLevel;
	private Integer auditState;
	private Integer beinHospitalTimes;
	private String inHospitalNo;
	//private String 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCareLevel() {
		return careLevel;
	}
	public void setCareLevel(String careLevel) {
		this.careLevel = careLevel;
	}
	
	
}
