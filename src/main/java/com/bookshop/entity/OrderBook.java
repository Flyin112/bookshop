package com.bookshop.entity;

import java.math.BigDecimal;

public class OrderBook {

	private int orserBookId;
	
	private int orderId;
	
	private int bookId;
	
	private int bookNum;
	
	private BigDecimal bookPrice;

	public int getOrserBookId() {
		return orserBookId;
	}

	public void setOrserBookId(int orserBookId) {
		this.orserBookId = orserBookId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
}
