package com.bookshop.entity;

import java.util.Date;

public class UserInfo {
	private int userId;
	
	private String userName;
	
	private String UserPassword;
	
	private String salt;
	
	private short role;
	
	private Date createTime;
	
	private String email;
	
	private String phone;
	
	private short state;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public short getRole() {
		return role;
	}

	public void setRole(short role) {
		this.role = role;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}
}
