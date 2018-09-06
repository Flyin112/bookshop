package com.bookshop.dto;

import java.io.Serializable;

public class Result implements Serializable{

	private int statu;
	
	private String message;
	
	private Object data;
	
	public Result() {
		
	}
	
	public Result(int statu, String message, Object data) {
		this.setStatu(statu);
		this.setMessage(message);
		this.setData(data);
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
