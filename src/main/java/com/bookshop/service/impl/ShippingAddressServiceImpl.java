package com.bookshop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.dao.ShippingAddressDao;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.ShippingAddress;
import com.bookshop.service.ShippingAddressService;
import com.bookshop.web.exception.SystemException;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{
	
	@Autowired
	private ShippingAddressDao shippingAddressDao;

	@Override
	public boolean addAddress(ShippingAddress shippingAddress) {
		int total = shippingAddressDao.queryAddressCountByUser(shippingAddress.getUserId());
		if(total == 5)
			throw new SystemException("收货地址已满", 0);
		return shippingAddressDao.addAddress(shippingAddress) == 1 ? true : false;
	}

	@Override
	public boolean deleteAddress(int shippingAddressId, int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shippingAddressId", shippingAddressId);
		map.put("userId", userId);
		return shippingAddressDao.deleteAddress(map) == 1 ? true : false;
	}

	@Override
	public boolean updateAddress(ShippingAddress shippingAddress) {
		return shippingAddressDao.updateAddress(shippingAddress) == 1 ? true : false;
	}

	@Override
	public ResponsePageInfo<ShippingAddress> queryAddressByUser(int userId) {
		List<ShippingAddress> rows = shippingAddressDao.queryAddressByUser(userId);
		int total = shippingAddressDao.queryAddressCountByUser(userId);
		ResponsePageInfo<ShippingAddress> responsePageInfo = new ResponsePageInfo<>(total, rows);
		return responsePageInfo;
	}

}
