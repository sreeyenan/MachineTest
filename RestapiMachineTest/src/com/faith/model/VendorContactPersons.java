package com.faith.model;

public class VendorContactPersons {
	
	int vId;
	String vName;
	String vAddress;
	String vLocation;
	String vService;
	int vPincode;
	int cpId;
	String cpName;
	int cpVId;
	String cpDepartment;
	String cpEmail;
	String cpPhone;
	String isActive;
	public VendorContactPersons() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorContactPersons(int vId, String vName, String vAddress, String vLocation, String vService, int vPincode,
			int cpId, String cpName, int cpVId, String cpDepartment, String cpEmail, String cpPhone, String isActive) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddress = vAddress;
		this.vLocation = vLocation;
		this.vService = vService;
		this.vPincode = vPincode;
		this.cpId = cpId;
		this.cpName = cpName;
		this.cpVId = cpVId;
		this.cpDepartment = cpDepartment;
		this.cpEmail = cpEmail;
		this.cpPhone = cpPhone;
		this.isActive = isActive;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvAddress() {
		return vAddress;
	}
	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}
	public String getvLocation() {
		return vLocation;
	}
	public void setvLocation(String vLocation) {
		this.vLocation = vLocation;
	}
	public String getvService() {
		return vService;
	}
	public void setvService(String vService) {
		this.vService = vService;
	}
	public int getvPincode() {
		return vPincode;
	}
	public void setvPincode(int vPincode) {
		this.vPincode = vPincode;
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
	public String getCpPhone() {
		return cpPhone;
	}
	public void setCpPhone(String cpPhone) {
		this.cpPhone = cpPhone;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "VendorContactPersons [vId=" + vId + ", vName=" + vName + ", vAddress=" + vAddress + ", vLocation="
				+ vLocation + ", vService=" + vService + ", vPincode=" + vPincode + ", cpId=" + cpId + ", cpName="
				+ cpName + ", cpVId=" + cpVId + ", cpDepartment=" + cpDepartment + ", cpEmail=" + cpEmail + ", cpPhone="
				+ cpPhone + ", isActive=" + isActive + "]";
	}

}
