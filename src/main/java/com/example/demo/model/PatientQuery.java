package com.example.demo.model;
/**
 * 查询搜索类
 * @author yanzhiying
 *
 */
public class PatientQuery {
	private String patientName;
	private Integer checkStatus;
	private String inHospitalNo;
	private String patientType;
	private String patientDoctor;
	private String careLevel;
	private Integer pageSize;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getInHospitalNo() {
		return inHospitalNo;
	}
	public void setInHospitalNo(String inHospitalNo) {
		this.inHospitalNo = inHospitalNo;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public String getPatientDoctor() {
		return patientDoctor;
	}
	public void setPatientDoctor(String patientDoctor) {
		this.patientDoctor = patientDoctor;
	}
	public String getCareLevel() {
		return careLevel;
	}
	public void setCareLevel(String careLevel) {
		this.careLevel = careLevel;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PatientQuery [patientName=" + patientName + ", checkStatus=" + checkStatus + ", inHospitalNo="
				+ inHospitalNo + ", patientType=" + patientType + ", patientDoctor=" + patientDoctor + ", careLevel="
				+ careLevel + ", pageSize=" + pageSize + "]";
	}
	
	
	
	
	
}
