package com.neusoft.SP01.po;

public class User {
	private Integer userId;
	private String account;
	private String userName;
	private String password;
	private String tel;
	private String  email;
	private String employmentDate;
	private Integer type;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmploymentDate() {
		return employmentDate;
	}
	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public User() {
		super();
	}
	
	
}
