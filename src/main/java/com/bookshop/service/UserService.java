package com.bookshop.service;

import com.bookshop.dto.ResponseUserDto;
import com.bookshop.dto.RequestUserDto;

public interface UserService {

	/**
	 * 检查用户名是否重复
	 * @param userName
	 * @return true-已存在，false-不存在
	 */
	boolean checkUserName(String userName);
	
	/**
	 * 登录验证
	 * @param userName
	 * @param password
	 * @return
	 */
	ResponseUserDto loginCheck(String userName, String password);
	
	/**
	 * SHA256(SHA256(password) + salt)
	 * @param password
	 * @param salt
	 * @return
	 */
	String encrypt(String password, String salt);
	
	/**
	 * 随机盐
	 * @return
	 */
	String getNewSalt();
	
	/**
	 * 用户注册
	 * @param userInfo
	 * @param isAdmin
	 * @return
	 */
	boolean addUser(RequestUserDto userDto, boolean isAdmin);
}
