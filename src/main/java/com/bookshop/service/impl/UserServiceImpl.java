package com.bookshop.service.impl;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.dao.UserInfoDao;
import com.bookshop.dto.ResponseUserDto;
import com.bookshop.dto.RequestUserDto;
import com.bookshop.entity.UserInfo;
import com.bookshop.service.UserService;
import org.apache.commons.codec.binary.Base64;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public boolean checkUserName(String userName) {
		String result = userInfoDao.queryUserNameByUserName(userName);
		return result == null ? false : true;
	}

	@Override
	public ResponseUserDto loginCheck(String userName, String password) {
		UserInfo userInfo = userInfoDao.queryUserByName(userName);
		if(userInfo == null)
			return null;
		if(userInfo.getState() == 1)
			return null;
		String salt = userInfo.getSalt();
		String hashPassword = encrypt(password, salt);
		if(hashPassword.equals(userInfo.getUserPassword())) {
			ResponseUserDto userDto = new ResponseUserDto();
			userDto.setUserId(userInfo.getUserId());
			userDto.setUserName(userInfo.getUserName());
			userDto.setRole(userInfo.getRole());
			userDto.setEmail(userInfo.getEmail());
			userDto.setPhone(userInfo.getPhone());
			userDto.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userInfo.getCreateTime()));
			userDto.setState(userInfo.getState());
			return userDto;
		}
		return null;
	}

	@Override
	public String encrypt(String password, String salt) {
		String hashPassword = new Sha256Hash(password).toString();
		Sha256Hash sha256 = new Sha256Hash(hashPassword, salt);
		return sha256.toString();
	}

	@Override
	public String getNewSalt() {
		byte[] bytes = SecureRandom.getSeed(48);
		String salt = Base64.encodeBase64String(bytes);
		return salt;
	}

	@Override
	public boolean addUser(RequestUserDto userDto, boolean isAdmin) {
		String salt = getNewSalt();
		String hashPassword = encrypt(userDto.getPassword(), salt);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userDto.getUserName());
		userInfo.setUserPassword(hashPassword);
		userInfo.setSalt(salt);
		userInfo.setCreateTime(new Date());
		if(isAdmin)
			userInfo.setRole((short) 1);
		else
			userInfo.setRole((short) 0);
		userInfo.setState((short) 0);
		userInfo.setPhone(userDto.getPhone());
		userInfo.setEmail(userDto.getEmail());
		if(userInfoDao.addUser(userInfo) > 0)
			return true;
		return false;
	}

}
