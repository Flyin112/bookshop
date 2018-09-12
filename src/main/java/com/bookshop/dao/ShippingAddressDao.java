package com.bookshop.dao;

import java.util.List;
import java.util.Map;

import com.bookshop.entity.ShippingAddress;

public interface ShippingAddressDao {
	
	int addAddress(ShippingAddress shippingAddress);
	
	int deleteAddress(Map<String, Object> map);
	
	int updateAddress(ShippingAddress shippingAddress);
	
	List<ShippingAddress> queryAddressByUser(int userId);
	
	int queryAddressCountByUser(int userId);
}
