package com.bookshop.service;

import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.RequestQueryCondition;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.BookInfo;

public interface BookService {

	boolean addBook(BookInfo bookInfo);
	
	boolean updateBook(BookInfo bookInfo);
	
	BookInfo queryBookInfo(int bookId);
	
	ResponsePageInfo<BookInfo> queryAllBookInfoByAdmin(RequestPageInfo page);
	
	ResponsePageInfo<BookInfo> queryBookInfo(RequestQueryCondition condition);
}
