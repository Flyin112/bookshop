package com.bookshop.dto;

import java.util.Date;

public class ResponseUserDto {

	private int userId;
	
	private String userName;
	
	private short role;
	
	private String createTime;
	
	private String email;
	
	private String phone;
	
	private short state;
	
	public ResponseUserDto() {
		
	}

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

	public short getRole() {
		return role;
	}

	public void setRole(short role) {
		this.role = role;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
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
