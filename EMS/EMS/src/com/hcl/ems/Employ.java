package com.hcl.ems;

import java.math.BigDecimal;
import java.sql.Date;

public class Employ {
	private Integer empId;
	private String empName;
	private String empMail;
	private BigDecimal empMobNo;
	private String empDpeName;
	private Date empDateJoined;
	private int empLeaveBalance;
	private int empMgrId;
	
	public Integer getEmpMgrId() {
		return empMgrId;
	}
	public void setEmpMgrId(Integer empId) {
		empMgrId = empId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int eMP_ID) {
		empId = eMP_ID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String eMP_NAME) {
		empName = eMP_NAME;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String eMP_EMAIL) {
		empMail = eMP_EMAIL;
	}
	public BigDecimal getEmpMobNo() {
		return empMobNo;
	}
	public void setEmpMobNo(BigDecimal bigDecimal) {
		empMobNo = bigDecimal;
	}
	public String getEmpDpeName() {
		return empDpeName;
	}
	public void setEmpDpeName(String eMP_DPT_NAME) {
		empDpeName = eMP_DPT_NAME;
	}
	public Date getEmpDateJoined() {
		return empDateJoined;
	}
	public void setEmpDateJoined(Date eMP_DATE_JOINED) {
		empDateJoined = eMP_DATE_JOINED;
	}
	public int getEmpLeaveBalance() {
		return empLeaveBalance;
	}
	public void setEmpLeaveBalance(int eMP_LEAVE_BALANCE) {
		empLeaveBalance = eMP_LEAVE_BALANCE;
	}
	
	
	
}	
