package com.bookshop.dao;

import java.util.List;

import com.bookshop.SQL.PageInfoForSQL;
import com.bookshop.entity.BookType;

public interface BookTypeDao {
	
	/**
	 * 添加图书类型
	 * @param bookType 图书类型
	 * @return 受影响行数
	 */
	int addBookType(BookType bookType);
	
	/**
	 * 删除某图书类型
	 * @param typeId 自增主键
	 * @return 受影响行数
	 */
	int deleteBookType(int typeId);
	
	/**
	 * 更新图书类型信息
	 * @param bookType 图书类型
	 * @return 受影响行数
	 */
	int updateBookType(BookType bookType);
	
	/**
	 * 查询图书类型详情
	 * @param typeId 自增主键
	 * @return 图书类型详情
	 */
	BookType queryBookType(int typeId);
	
	/**
	 * 批量查询
	 * @param pageInfoForSQL 分页信息
	 * @return 查询结果
	 */
	List<BookType> queryBookTypes(PageInfoForSQL pageInfoForSQL);
	
	/**
	 * 查询总数
	 * @return
	 */
	int queryCountForBookTypes();
}
