package com.bookshop.utils;

import javax.servlet.http.HttpSession;

import com.bookshop.dto.ResponseUserDto;
import com.bookshop.web.exception.SystemException;

public class SessionUtil {
	
	public static int getUserId(HttpSession session) {
		Object object = session.getAttribute("userId");
		if(object == null)
			throw new SystemException("没有权限", 0);
		return (Integer)object;
	}

	public static boolean checkUserId(HttpSession session, int userId) {
		Object object = session.getAttribute("userId");
		if(object == null)
			return false;
		Integer sessionUserId = (Integer)object;
		if(!sessionUserId.equals(userId))
			return false;
		return true;
	}
	
	public static void setUserInfo(HttpSession session, ResponseUserDto responseUserDto) {
		session.setAttribute("userId", responseUserDto.getUserId());
		session.setAttribute("userName", responseUserDto.getUserName());
		session.setAttribute("userRole", responseUserDto.getRole());
	}
}
