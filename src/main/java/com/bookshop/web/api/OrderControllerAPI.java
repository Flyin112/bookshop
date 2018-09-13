package com.bookshop.web.api;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.annotation.LoginRequired;
import com.bookshop.dto.Result;
import com.bookshop.entity.Order;
import com.bookshop.enums.UserRole;
import com.bookshop.service.OrderService;
import com.bookshop.utils.SessionUtil;

@Controller
@RequestMapping("/api/user/order")
@LoginRequired(requiredRole = UserRole.USER)
public class OrderControllerAPI {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/create")
	@ResponseBody
	public Result createOrder(HttpSession session, int addressId) {
		int userId = SessionUtil.getUserId(session);
		Order order = orderService.createOrder(userId, addressId);
		return new Result(1, "生成订单成功", order);
	}
	
	@RequestMapping("/cancel")
	@ResponseBody
	public Result cancelOrder(HttpSession session, @Min(1) int orderId) {
		int userId = SessionUtil.getUserId(session);
		orderService.cancelOrder(userId, orderId);
		return new Result(1, "取消订单成功", null);
	}
	
	@RequestMapping("/pay")
	@ResponseBody
	public Result payOrder(HttpSession session, @Min(1) int orderId) {
		int userId = SessionUtil.getUserId(session);
		orderService.payForOrder(userId, orderId);
		return new Result(1, "付款成功", null);
	}
	
}
