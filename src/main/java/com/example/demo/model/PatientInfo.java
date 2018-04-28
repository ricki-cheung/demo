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
	private String outPatientNo;
	private String patientType;
	private String patientDoctor;
	private String primaryNurse;
	private Integer hospitalizationDays;
	private String diagnoseDoctor;
	private Integer outHospitalFlag;
	
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
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public Integer getBeinHospitalTimes() {
		return beinHospitalTimes;
	}
	public void setBeinHospitalTimes(Integer beinHospitalTimes) {
		this.beinHospitalTimes = beinHospitalTimes;
	}
	public String getInHospitalNo() {
		return inHospitalNo;
	}
	public void setInHospitalNo(String inHospitalNo) {
		this.inHospitalNo = inHospitalNo;
	}
	public String getOutPatientNo() {
		return outPatientNo;
	}
	public void setOutPatientNo(String outPatientNo) {
		this.outPatientNo = outPatientNo;
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
	public String getPrimaryNurse() {
		return primaryNurse;
	}
	public void setPrimaryNurse(String primaryNurse) {
		this.primaryNurse = primaryNurse;
	}
	public Integer getHospitalizationDays() {
		return hospitalizationDays;
	}
	public void setHospitalizationDays(Integer hospitalizationDays) {
		this.hospitalizationDays = hospitalizationDays;
	}
	public String getDiagnoseDoctor() {
		return diagnoseDoctor;
	}
	public void setDiagnoseDoctor(String diagnoseDoctor) {
		this.diagnoseDoctor = diagnoseDoctor;
	}
	public Integer getOutHospitalFlag() {
		return outHospitalFlag;
	}
	public void setOutHospitalFlag(Integer outHospitalFlag) {
		this.outHospitalFlag = outHospitalFlag;
	}
	
	
}
