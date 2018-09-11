package com.bookshop.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.bookshop.web.validation.ValidGroup1;

public class RequestUserDto {

	@NotBlank(message = "用户名不能为空", groups = {Default.class, ValidGroup1.class})
	@Size(min = 2, max = 20, message = "用户名长度应在2~20之间", groups = {Default.class, ValidGroup1.class})
	private String userName;
	
	@NotBlank(message = "密码不能为空", groups = {Default.class, ValidGroup1.class})
	private String password;
	
	@Email(message = "邮箱格式错误")
	@NotBlank(message = "邮箱格式错误")
	private String email;
	
	@Pattern(regexp = "^[1][3,4,5,8][0-9]{9}$", message = "手机格式错误")
	@NotBlank(message = "号码格式错误")
	private String phone;
	
	public RequestUserDto() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}
