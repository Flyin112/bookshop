package com.bookshop.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.dao.CartDao;
import com.bookshop.dao.OrderDao;
import com.bookshop.dao.ShippingAddressDao;
import com.bookshop.entity.Cart;
import com.bookshop.entity.Order;
import com.bookshop.entity.OrderBook;
import com.bookshop.entity.ShippingAddress;
import com.bookshop.service.CartService;
import com.bookshop.service.OrderService;
import com.bookshop.utils.FormatUtil;
import com.bookshop.web.exception.SystemException;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ShippingAddressDao shippingAddressDao;
	
	@Autowired
	private CartService cartService;

	@Override
	@Transactional
	public Order createOrderAtFirst(int userId, int addressId) {
		int total = cartDao.queryCartCount(userId);
		if(total == 0)
			throw new SystemException("购物车为空", 0);
		List<Cart> cartList = cartDao.queryCarts(userId);
		for(Cart cart : cartList) {
			cartService.checkCart(cart.getBookNum(), cart.getBookId());
		}
		ShippingAddress address = null;
		if(addressId != 0) {
			address = shippingAddressDao.queryAddressById(addressId);
			if(address == null || address.getUserId() != userId)
				throw new SystemException("收货地址不存在", 0);
		}
		List<ShippingAddress> addressList = shippingAddressDao.queryAddressByUser(userId);
		if(addressList.size() == 0)
			throw new SystemException("收货地址不存在", 0);
		address = addressList.get(0);
		Date nowDate = new Date();
		String orderNo = FormatUtil.dateToString(nowDate, "yyyyMMddHHmmssSSSS");
		Order order = new Order();
		order.setOrderNo(orderNo);
		order.setCreateTime(nowDate);
		order.setUserId(userId);
		order.setAddress(address.getAddress());
		order.setPhone(address.getPhone());
		order.setReceiver(address.getReceiver());
		if(orderDao.addOrder(order) == 1) {
			int orderId = orderDao.queryOrderIdByOrderNo(orderNo);
			order.setOrderId(orderId);
			return order;
		}
		throw new SystemException("订单创建失败", 0);
	}

	@Override
	@Transactional
	public BigDecimal setOrderBooks(Order order) {
		List<Cart> cartList = cartDao.queryCarts(order.getUserId());
		OrderBook orderBook = null;
		BigDecimal totalMoney = new BigDecimal(0);
		for(Cart cart : cartList) {
			orderBook = new OrderBook();
			orderBook.setOrderId(order.getOrderId());
			orderBook.setBookId(cart.getBookId());
			orderBook.setBookNum(cart.getBookNum());
			orderBook.setBookPrice(cart.getBookPrice());
			totalMoney = totalMoney.add(orderBook.getBookPrice().multiply(new BigDecimal(orderBook.getBookNum())));
			orderDao.addOrderBook(orderBook);
		}
		cartDao.deleteAllByUser(order.getUserId());
		order.setTotalMoney(totalMoney);
		return totalMoney;
	}

	@Override
	@Transactional
	public Order createOrder(int userId, int addressId) {
		Order order = createOrderAtFirst(userId, addressId);
		BigDecimal totalMoney = setOrderBooks(order);
		orderDao.updateOrderMoney(order.getOrderId(), totalMoney);
		return order;
	}

	@Override
	@Transactional
	public void cancelOrder(int userId, int orderId) {
		Order order = orderDao.queryOrderByOrderId(orderId);
		if(order == null || order.getUserId() != userId)
			throw new SystemException("订单不存在", 0);
		short nowState = order.getState();
		if(nowState >= 2)
			throw new SystemException("订单无法取消", 0);
		if(nowState == 0)
			orderDao.setState(orderId, (short)4);
		if(nowState == 1)
			orderDao.setState(orderId, (short)5);
	}

	@Override
	@Transactional
	public void payForOrder(int userId, int orderId) {
		Order order = orderDao.queryOrderByOrderId(orderId);
		if(order == null || order.getUserId() != userId)
			throw new SystemException("订单不存在", 0);
		short nowState = order.getState();
		if(nowState != 0)
			throw new SystemException("订单状态错误", 0);
		orderDao.setState(orderId, (short)1);
	}

}
