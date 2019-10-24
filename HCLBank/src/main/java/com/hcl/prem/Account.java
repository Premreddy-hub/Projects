package com.hcl.prem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
@Id
private int accountnum;
private double amount;
private String address;
private String phone;
private char accounttype;
private int userid;
public int getAccountnum() {
	return accountnum;
}
public void setAccountnum(int accountnum) {
	this.accountnum = accountnum;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public char getAccounttype() {
	return accounttype;
}
public void setAccounttype(char accounttype) {
	this.accounttype = accounttype;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}

}
