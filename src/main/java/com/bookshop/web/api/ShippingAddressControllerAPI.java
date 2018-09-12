package com.bookshop.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.annotation.LoginRequired;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.dto.Result;
import com.bookshop.entity.ShippingAddress;
import com.bookshop.enums.UserRole;
import com.bookshop.service.ShippingAddressService;
import com.bookshop.utils.SessionUtil;
import com.bookshop.web.exception.SystemException;
import com.bookshop.web.validation.ValidGroup1;

@Controller
@RequestMapping("/api/user/address")
public class ShippingAddressControllerAPI {

	@Autowired
	private ShippingAddressService shippingAddressService;
	
	@RequestMapping("/list")
	@ResponseBody
	@LoginRequired(requiredRole = UserRole.User)
	private Result getAddressList(HttpSession session) {
		int userId = SessionUtil.getUserId(session);
		ResponsePageInfo<ShippingAddress> responsePageInfo = shippingAddressService.queryAddressByUser(userId);
		return new Result(1, "查询成功", responsePageInfo);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	@LoginRequired(requiredRole = UserRole.User)
	private Result addAddress(HttpSession session, @Validated(value = ValidGroup1.class) ShippingAddress address) {
		if(SessionUtil.checkUserId(session, address.getUserId())) {
			if(shippingAddressService.addAddress(address))
				return new Result(1, "插入成功", null);
			return new Result(0, "插入失败", null);
		}
		throw new SystemException("没有权限", 0);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	@LoginRequired(requiredRole = UserRole.User)
	private Result updateAddress(HttpSession session, @Validated ShippingAddress address) {
		if(SessionUtil.checkUserId(session, address.getUserId())) {
			if(shippingAddressService.updateAddress(address))
				return new Result(1, "修改成功", null);
			return new Result(0, "修改失败", null);
		}
		throw new SystemException("没有权限", 0);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@LoginRequired(requiredRole = UserRole.User)
	private Result deleteAddress(HttpSession session, int addressId) {
		boolean statu = shippingAddressService.deleteAddress(addressId, SessionUtil.getUserId(session));
		if(statu)
			return new Result(1, "删除成功", null);
		return new Result(0, "删除失败", null);
	}

}
