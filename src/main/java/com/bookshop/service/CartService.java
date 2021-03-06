package com.bookshop.service;

import java.math.BigDecimal;

import com.bookshop.dto.CartDto;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.Cart;

public interface CartService {
	
	ResponsePageInfo<CartDto> queryCartByUser(int userId);
	
	Cart queryCartByUserAndBook(int userId, int bookId);

	boolean updateCart(Cart cart, int op);
	
	boolean deleteAllByUser(int userId);
	
	BigDecimal checkCart(int num, int bookId);
}
