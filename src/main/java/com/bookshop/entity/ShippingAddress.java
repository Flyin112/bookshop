package com.bookshop.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotBlank;

import com.bookshop.web.validation.ValidGroup1;

public class ShippingAddress {

	@Min(value = 1, message = "Id范围错误")
	private int shippingAddressId;
	
	@Min(value = 1, message = "参数错误", groups = {ValidGroup1.class, Default.class})
	private int userId;
	
	@NotBlank(message = "收货地址不能为空", groups = {ValidGroup1.class, Default.class})
	private String address;
	
	@NotBlank(message = "收货人不能为空", groups = {ValidGroup1.class, Default.class})
	private String receiver;
	
	@Pattern(regexp = "^[1][3,4,5,8][0-9]{9}$", message = "手机格式错误", groups = {ValidGroup1.class, Default.class})
	@NotBlank(message = "号码格式错误", groups = {ValidGroup1.class, Default.class})
	private String phone;
	
	@NotBlank(message = "邮编不能为空", groups = {ValidGroup1.class, Default.class})
	private String postCode;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}
