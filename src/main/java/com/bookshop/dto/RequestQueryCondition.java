package com.bookshop.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class RequestQueryCondition {

	@Range(min = 1, max = 3, message = "参数错误")
	private int queryCol;
	
	@Range(min = 1, max = 3, message = "参数错误")
	private int queryOp;
	
	@NotBlank(message="搜索字段不能为空")
	private String value;
	
	@Valid
	@NotNull(message = "参数错误")
	private RequestPageInfo page;

	public int getQueryCol() {
		return queryCol;
	}

	public void setQueryCol(int queryCol) {
		this.queryCol = queryCol;
	}

	public int getQueryOp() {
		return queryOp;
	}

	public void setQueryOp(int queryOp) {
		this.queryOp = queryOp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public RequestPageInfo getPage() {
		return page;
	}

	public void setPage(RequestPageInfo page) {
		this.page = page;
	}
}
