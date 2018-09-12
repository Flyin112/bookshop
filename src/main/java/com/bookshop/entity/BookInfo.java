package com.bookshop.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class BookInfo {
	
	private int bookId;
	
	@Size(min = 1, max = 50, message = "书名长度应在1~50之间")
	private String bookName;
	
	@Size(min = 1, max = 50, message = "书名长度应在1~50之间")
	private String publisher;
	
	@NotNull(message = "日期不能为空")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishTime;
	
	@Size(max = 255, message = "简介长度应在0~255之间")
	private String introduction;
	
	@Size(min = 13, max = 13, message = "ISBN码长度应为13")
	private String ISBN13;
	
	@NotNull(message = "价格不为空")
	@DecimalMin(value = "0", message = "价格参数错误")
	private BigDecimal price;
	
	@Min(value = 0, message = "库存参数错误")
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
