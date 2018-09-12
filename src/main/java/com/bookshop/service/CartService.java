package com.bookshop.service;

import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.Cart;

public interface CartService {
	
	ResponsePageInfo<Cart> queryCartByUser(int userId);
	
	Cart queryCartByUserAndBook(int userId, int bookId);

	boolean updateCart(Cart cart, int op);
	
	boolean deleteAllByUser(int userId);
}
