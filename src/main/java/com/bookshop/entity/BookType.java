package com.bookshop.entity;

import org.hibernate.validator.constraints.NotBlank;

public class BookType {
	
	private int typeId;
	
	@NotBlank(message = "参数不能为空")
	private String typeName;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
