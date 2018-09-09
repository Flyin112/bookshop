package com.bookshop.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BookInfo {
	
	private int bookId;
	
	private String bookName;
	
	private String publisher;
	
	private Date publishTime;
	
	private String introduction;
	
	private String ISBN10;
	
	private String ISBN13;
	
	private BigDecimal price;
	
	private int needDeliverNum;
	
	private int realStoreNum;
	
	private int typeId;
	
	private short state;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getISBN10() {
		return ISBN10;
	}

	public void setISBN10(String iSBN10) {
		ISBN10 = iSBN10;
	}

	public String getISBN13() {
		return ISBN13;
	}

	public void setISBN13(String iSBN13) {
		ISBN13 = iSBN13;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getNeedDeliverNum() {
		return needDeliverNum;
	}

	public void setNeedDeliverNum(int needDeliverNum) {
		this.needDeliverNum = needDeliverNum;
	}

	public int getRealStoreNum() {
		return realStoreNum;
	}

	public void setRealStoreNum(int realStoreNum) {
		this.realStoreNum = realStoreNum;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}
}
