package com.bookshop.dao;

import com.bookshop.entity.UserInfo;

public interface UserInfoDao {
	
	/**
	 * 
	 * @param userInfo
	 * @return
	 */
	int addUser(UserInfo userInfo);
}
