package com.bookshop.dao;

import java.util.List;
import java.util.Map;

import com.bookshop.entity.UserInfo;

public interface UserInfoDao {
	
	/**
	 * 添加用户
	 * @param userInfo
	 * @return
	 */
	int addUser(UserInfo userInfo);
	
	/**
	 * 更新用户信息
	 * @param uerInfo
	 * @return
	 */
	int updateUser(UserInfo uerInfo);
	
	/**
	 * 管理员账号数量
	 * @return
	 */
	int queryAdminCount();
	
	/**
	 * 根据userId获取用户信息
	 * @param userId
	 * @return
	 */
	UserInfo queryUser(String userId);
	
	/**
	 * 根据userName获取用户信息
	 * @param userName
	 * @return
	 */
	UserInfo queryUserByName(String userName);
	
	/**
	 * 查询同名
	 * @param userName
	 * @return
	 */
	String queryUserNameByUserName(String userName);
	
	/**
	 * 条件查询
	 * @param queryMap
	 * @return
	 */
	List<UserInfo> queryAllUser(Map<String, Object> queryMap);
}
