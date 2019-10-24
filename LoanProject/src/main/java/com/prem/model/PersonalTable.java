package com.prem.model;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personaltable")
public class PersonalTable {

	@Id
	private int userid;
	private String fullname;
	private String address;
	private String contact_no;
	private String premium;
	private String legalresident;
	private int creditscore;
	

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getLegalresident() {
		return legalresident;
	}
	public void setLegalresident(String legalresident) {
		this.legalresident = legalresident;
	}
	public int getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}
	
	@Override
	public String toString() {
		return "PersonalTable [userid=" + userid + ", fullname=" + fullname + ", address=" + address + ", contact_no="
				+ contact_no + ", premium=" + premium + ", legalresident=" + legalresident + ", creditscore="
				+ creditscore + "]";
	}
 	
	
	
	
}
