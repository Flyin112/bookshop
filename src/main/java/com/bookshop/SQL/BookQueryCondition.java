package com.bookshop.SQL;

import com.bookshop.dto.RequestQueryCondition;

public class BookQueryCondition {

	private String column;
	
	private String option;
	
	private String value;
	
	public BookQueryCondition() {
		
	}
	
	public BookQueryCondition(RequestQueryCondition condition) {
		switch (condition.getQueryCol()) {
		case 1:
			this.setColumn("bookName");
			break;
		case 2:
			this.setColumn("publisher");
			break;
		case 3:
			this.setColumn("ISBN13");
			break;
		default:
			this.setColumn("bookName");
			break;
		}
		switch (condition.getQueryOp()) {
		case 1:
			this.setOption("=");
			break;
		case 2:
			this.setOption("leftlike");
			break;
		case 3:
			this.setOption("like");
			break;
		default:
			this.setOption("=");
			break;
		}
		this.setValue(condition.getValue());
	}
	
	public BookQueryCondition(String column, String option, String value) {
		this.setColumn(column);
		this.setOption(option);
		this.setValue(value);
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getOption() {
		if(option == "leftlike")
			return "like";
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getValue() {
		if(option == "like")
			return "%" + value + "%";
		if(option == "leftlike")
			return value + "%";
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
