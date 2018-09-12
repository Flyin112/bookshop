package com.bookshop.dao;

import java.util.List;
import java.util.Map;

import com.bookshop.entity.Cart;

public interface CartDao {

	int addCart(Cart cart);
	
	int deleteCart(Cart cart);
	
	int deleteAllByUser(int userId);
	
	int updateCart(Cart cart);
	
	List<Cart> queryCarts(int userId);
	
	Cart queryCart(Map<String, Object> map);
	
	int queryCartCount(int userId);
}
