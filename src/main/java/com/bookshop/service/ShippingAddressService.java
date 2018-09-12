package com.bookshop.service;

import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.ShippingAddress;

public interface ShippingAddressService {

	boolean addAddress(ShippingAddress shippingAddress);
	
	boolean deleteAddress(int shippingAddressId, int userId);
	
	boolean updateAddress(ShippingAddress shippingAddress);
	
	ResponsePageInfo<ShippingAddress> queryAddressByUser(int userId);
}
