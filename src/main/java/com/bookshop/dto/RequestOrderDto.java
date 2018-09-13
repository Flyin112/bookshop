package com.bookshop.dto;

import javax.validation.constraints.Min;

public class RequestOrderDto {

	private Short state;
	
	@Min(1)
	private int pageNumber;
	
	@Min(1)
	private int pageSize;

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
