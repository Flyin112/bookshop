package com.bookshop.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.bookshop.entity.Order;
import com.bookshop.entity.OrderBook;

public interface OrderDao {
	
	int addOrder(Order order);
	
	int updateOrderMoney(@Param("orderId")int orderId, @Param("totalMoney")BigDecimal totalMoney);
	
	int updateOrderAddress(Order order);
	
	int setState(@Param("orderId")int orderId, @Param("state")short state);
	
	int addOrderBook(OrderBook orderBook);
	
	int queryOrderIdByOrderNo(String orderNo);
	
	Order queryOrderByOrderId(int orderId);
}
