package com.faith.model;

public class ContactPerson {
	
	int cpId;
	String cpName;
	int cpVId;
	String cpDepartment;
	String cpEmail;
	int cpPhone;
	String isActive;
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public ContactPerson(String isActive) {
		super();
		this.isActive = isActive;
	}
	public ContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactPerson(int cpId, String cpName, int cpVId, String cpDepartment, String cpEmail, int cpPhone) {
		super();
		this.cpId = cpId;
		this.cpName = cpName;
		this.cpVId = cpVId;
		this.cpDepartment = cpDepartment;
		this.cpEmail = cpEmail;
		this.cpPhone = cpPhone;
	}
	public int getCpId() {
		return cpId;
	}
	public void setCpId(int cpId) {
		this.cpId = cpId;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public int getCpVId() {
		return cpVId;
	}
	public void setCpVId(int cpVId) {
		this.cpVId = cpVId;
	}
	public String getCpDepartment() {
		return cpDepartment;
	}
	public void setCpDepartment(String cpDepartment) {
		this.cpDepartment = cpDepartment;
	}
	public String getCpEmail() {
		return cpEmail;
	}
	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}
	public int getCpPhone() {
		return cpPhone;
	}
	public void setCpPhone(int cpPhone) {
		this.cpPhone = cpPhone;
	}
	@Override
	public String toString() {
		return "ContactPerson [cpId=" + cpId + ", cpName=" + cpName + ", cpVId=" + cpVId + ", cpDepartment="
				+ cpDepartment + ", cpEmail=" + cpEmail + ", cpPhone=" + cpPhone + ", isActive=" + isActive + "]";
	}

}
