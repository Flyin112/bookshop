package com.bookshop.service;

import java.util.List;

import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.BookType;

public interface BookTypeService{
	
	/**
	 * 添加图书类型
	 * @param bookType
	 * @return 是否成功
	 */
	boolean addBookType(BookType bookType);
	
	/**
	 * 删除图书类型
	 * @param typeId
	 * @return 是否成功
	 */
	boolean deleteBookType(int typeId);
	
	/**
	 * 修改图书类型
	 * @param bookType
	 * @return 是否成功
	 */
	boolean updateBookType(BookType bookType);
	
	/**
	 * 查询图书类型
	 * @param typeId
	 * @return 结果
	 */
	BookType queryBookType(int typeId);
	
	/**
	 * 分页查询
	 * @param page 前端分页信息
	 * @return
	 */
	ResponsePageInfo<BookType> queryBookTypes(RequestPageInfo page);
	
	/**
	 * 查询所有信息
	 * @return
	 */
	List<BookType> queryBookTypes();
	
}