package com.bookshop.service;

import java.math.BigDecimal;

import com.bookshop.entity.Order;

public interface OrderService {
	
	Order createOrder(int userId, int addressId);

	Order createOrderAtFirst(int userId, int addressId);
	
	BigDecimal setOrderBooks(Order order);
	
	void cancelOrder(int userId, int orderId);
	
	void payForOrder(int userId, int orderId);
}
