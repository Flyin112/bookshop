package com.bookshop.dto;

import java.math.BigDecimal;

public class CartDto {

	private long cartId;
	
	private int userId;
	
	private int bookNum;
	
	private BigDecimal bookPrice;
	
	private ResponseBookDetailDto book;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public ResponseBookDetailDto getBook() {
		return book;
	}

	public void setBook(ResponseBookDetailDto book) {
		this.book = book;
	}
}
