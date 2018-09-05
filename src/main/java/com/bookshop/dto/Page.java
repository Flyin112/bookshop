package com.bookshop.dto;

public class Page {

	//第几页
	private int pageNumber;

	//每页大小
	private int pageSize;
	
	public Page() {
		
	}
	
	public Page(int pageNumber, int pageSize) {
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