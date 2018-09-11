package com.bookshop.enums;

public enum UserRole {
	NORMAL(-1),     //未登录
	User(0),        //普通用户
	ADMIN(1);       //管理员
	
	private int level;
	
	private UserRole(int level) {
		this.setLevel(level);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
