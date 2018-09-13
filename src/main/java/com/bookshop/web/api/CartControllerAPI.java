package com.bookshop.web.api;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.annotation.LoginRequired;
import com.bookshop.dto.CartDto;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.dto.Result;
import com.bookshop.entity.Cart;
import com.bookshop.enums.UserRole;
import com.bookshop.service.CartService;
import com.bookshop.utils.SessionUtil;

@Controller
@RequestMapping("/api/user/cart")
@LoginRequired(requiredRole = UserRole.USER)
public class CartControllerAPI {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Result getCartList(HttpSession session) {
		int userId = SessionUtil.getUserId(session);
		ResponsePageInfo<CartDto> responsePageInfo = cartService.queryCartByUser(userId);
		return new Result(1, "查询成功", responsePageInfo);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Result addCart(HttpSession session, int bookId, @Min(1)int num, @Size(min = 0, max = 1)int op) {
		int userId = SessionUtil.getUserId(session);
		Cart cart = new Cart();
		cart.setBookId(bookId);
		cart.setUserId(userId);
		cart.setBookNum(num);
		cartService.updateCart(cart, op);
		return new Result(1, "操作成功", null);
	}
	
	@RequestMapping("/clean")
	@ResponseBody
	public Result cleanCart(HttpSession session) {
		int userId = SessionUtil.getUserId(session);
		cartService.deleteAllByUser(userId);
		return new Result(1, "操作成功", null);
	}
}
