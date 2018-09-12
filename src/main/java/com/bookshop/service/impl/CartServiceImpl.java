package com.bookshop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.dao.CartDao;
import com.bookshop.dto.CartDto;
import com.bookshop.dto.ResponseBookDetailDto;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.Cart;
import com.bookshop.service.BookService;
import com.bookshop.service.CartService;
import com.bookshop.web.exception.SystemException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired 
	private BookService bookService;

	@Override
	public ResponsePageInfo<CartDto> queryCartByUser(int userId) {
		List<Cart> list = cartDao.queryCarts(userId);
		int total = cartDao.queryCartCount(userId);
		List<CartDto> rows = new ArrayList<CartDto>();
		for(Cart cart : list) {
			CartDto cartDto = new CartDto();
			cartDto.setCartId(cart.getCartId());
			cartDto.setUserId(cart.getUserId());
			cartDto.setBookNum(cart.getBookNum());
			ResponseBookDetailDto book = bookService.queryBookDetail(cart.getBookId());
			cartDto.setBook(book);
			rows.add(cartDto);
		}
		return new ResponsePageInfo<CartDto>(total, rows);
	}

	@Override
	public boolean updateCart(Cart cart, int op) {
		Map<String, Object> map = bookService.queryBookNeedNum(cart.getBookId());
		if(map.isEmpty())
			throw new SystemException("图书不存在", 0);
		Object o1 = map.get("realNum");
		Object o2 = map.get("neadNum");
		int realNum = 0;
		int needNum = 0;
		if(o1 != null)
			realNum = (int)o1;
		if(o2 != null)
			needNum = (int)o1;
		if(cart.getBookNum() > realNum - needNum)
			throw new SystemException("库存不足", 0);
		Cart oldCart = queryCartByUserAndBook(cart.getUserId(), cart.getBookId());
		if(oldCart != null) {
			cart.setCartId(oldCart.getCartId());
			if(op == 0) {
				if(cart.getBookNum() > oldCart.getBookNum())
					throw new SystemException("参数错误", 0);
				if(cart.getBookNum() == oldCart.getBookNum()) {
					cartDao.deleteCart(oldCart);
					return true;
				}
				cart.setBookNum(oldCart.getBookNum() - cart.getBookNum());
			}
			else
				cart.setBookNum(oldCart.getBookNum() + cart.getBookNum());
			cartDao.updateCart(cart);
		}
		else {
			if(op == 0)
				throw new SystemException("参数错误", 0);
			cartDao.addCart(cart);
		}
		return true;
	}

	@Override
	public Cart queryCartByUserAndBook(int userId, int bookId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("bookId", bookId);
		return cartDao.queryCart(map);
	}

	@Override
	public boolean deleteAllByUser(int userId) {
		cartDao.deleteAllByUser(userId);
		return true;
	}

	
}
