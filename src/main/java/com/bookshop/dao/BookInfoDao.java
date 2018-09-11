package com.bookshop.dao;

import java.util.List;
import java.util.Map;

import com.bookshop.SQL.BookQueryCondition;
import com.bookshop.entity.BookInfo;

public interface BookInfoDao {

	/**
	 * 添加图书信息
	 * @param bookInfo
	 * @return
	 */
	int addBook(BookInfo bookInfo);
	
	/**
	 * 更新图书信息
	 * @param bookInfo
	 * @return
	 */
	int updateBook(BookInfo bookInfo);
	
	/**
	 * 根据Id查询图书
	 * @param bookId
	 * @return
	 */
	BookInfo queryBookById(int bookId);
	
	/**
	 * 精确查询/模糊查询/左匹配查询
	 * @param queryMap
	 * @return
	 */
	List<BookInfo> queryBook(Map<String, Object> queryMap);
	
	/**
	 * 返回满足条件总数
	 * @param condition
	 * @return
	 */
	int queryBookCount(BookQueryCondition condition);
}
