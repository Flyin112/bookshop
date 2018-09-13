package com.bookshop.web.api;

import javax.servlet.http.HttpSession;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.annotation.LoginRequired;
import com.bookshop.dto.RequestUserDto;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.dto.ResponseUserDto;
import com.bookshop.dto.Result;
import com.bookshop.entity.ShippingAddress;
import com.bookshop.enums.UserRole;
import com.bookshop.service.ShippingAddressService;
import com.bookshop.service.UserService;
import com.bookshop.utils.SessionUtil;
import com.bookshop.web.exception.SystemException;
import com.bookshop.web.validation.ValidGroup1;

@Controller
@RequestMapping("/api/user")
public class UserControllerAPI {

	@Autowired
	private UserService userService;

	
	@RequestMapping("/register")
	@ResponseBody
	private Result register(HttpSession session, @Validated(value = Default.class) RequestUserDto userDto) {
		if(userService.addUser(userDto, false)) {
			session.invalidate();
			return new Result(1, "注册成功", null);
		}
		return new Result(0, "注册失败", null);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	private Result loginCheck(HttpSession session, @Validated(value = ValidGroup1.class) RequestUserDto userDto) {
		ResponseUserDto responseUserDto = userService.loginCheck(userDto.getUserName(), userDto.getPassword());
		if(responseUserDto != null) {
			SessionUtil.setUserInfo(session, responseUserDto);
			return new Result(1, "登录成功", responseUserDto);
		}
		return new Result(0, "登录失败", null);
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	@LoginRequired(requiredRole = UserRole.USER)
	private Result logout(HttpSession session) {
		session.invalidate();
		return new Result(1, "已登出", null);
	}
	
	@RequestMapping("/checkUserName")
	@ResponseBody
	private Result checkUserName(String userName) {
		if(userService.checkUserName(userName))
			return new Result(0, "用户名宫重复", null);
		return new Result(1, "用户名可以使用", null);
	}
	
	
}
