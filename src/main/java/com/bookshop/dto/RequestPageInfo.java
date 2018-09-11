package com.bookshop.dto;

import javax.validation.constraints.Min;

public class RequestPageInfo {

	//第几页
	@Min(value = 1, message = "参数错误")
	private int pageNumber;

	//每页大小
	@Min(value = 1, message = "参数错误")
	private int pageSize;
	
	public RequestPageInfo() {
		
	}
	
	public RequestPageInfo(int pageNumber, int pageSize) {
		this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
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
