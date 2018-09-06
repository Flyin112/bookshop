package com.bookshop.dto;

import java.util.List;

public class ResponsePageInfo<T> {
	private int total;
	
	private List<T> rows;
	
	public ResponsePageInfo(int total, List<T> rows){
		this.setTotal(total);
		this.setRows(rows);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
