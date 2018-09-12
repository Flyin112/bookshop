package com.bookshop.dto;

public class CartDto {

	private long cartId;
	
	private int userId;
	
	private int bookNum;
	
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

	public ResponseBookDetailDto getBook() {
		return book;
	}

	public void setBook(ResponseBookDetailDto book) {
		this.book = book;
	}
}
