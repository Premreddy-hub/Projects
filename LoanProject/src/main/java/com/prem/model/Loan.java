package com.prem.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	private int propertyid;
	private int userid;
	private int amount;
	private int area_code;
	private int property_sq;
	
	
	public int getProperty_sq() {
		return property_sq;
	}
	public void setProperty_sq(int property_sq) {
		this.property_sq = property_sq;
	}
	public int getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	
	
	@Override
	public String toString() {
		return "Loan [propertyid=" + propertyid + ", userid=" + userid + ", amount=" + amount + ", area_code="
				+ area_code + "]";
	}
	public Loan(int propertyid, int userid, int amount, int area_code, int property_sq) {
		super();
		this.propertyid = propertyid;
		this.userid = userid;
		this.amount = amount;
		this.area_code = area_code;
		this.property_sq = property_sq;
	}
	
	

}
