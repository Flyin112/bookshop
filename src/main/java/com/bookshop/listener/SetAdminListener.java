package com.bookshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bookshop.dao.UserInfoDao;
import com.bookshop.dto.RequestUserDto;
import com.bookshop.service.UserService;

public class SetAdminListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		UserService userService = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()).getBean(UserService.class);
		UserInfoDao userInfoDao = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()).getBean(UserInfoDao.class);
		int count = userInfoDao.queryAdminCount();
		if(count == 0) {
			RequestUserDto userDto = new RequestUserDto();
			userDto.setUserName("admin");
			userDto.setPassword("admin");
			userDto.setEmail("123456@123.com");
			userDto.setPhone("123456789");
			userService.addUser(userDto, true);
		}
	}

}
