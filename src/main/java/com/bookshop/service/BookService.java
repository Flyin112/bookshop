package com.bookshop.service;

import java.util.Map;

import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.RequestQueryCondition;
import com.bookshop.dto.ResponseBookDetailDto;
import com.bookshop.dto.ResponseSearchBookDto;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.BookInfo;

public interface BookService {

	boolean addBook(BookInfo bookInfo);
	
	boolean updateBook(BookInfo bookInfo);
	
	BookInfo queryBookInfo(int bookId);
	
	Map<String, Object> queryBookNeedNum(int bookId);
	
	ResponsePageInfo<BookInfo> queryAllBookInfoByAdmin(RequestPageInfo page);
	
	ResponsePageInfo<ResponseSearchBookDto> queryBookInfo(RequestQueryCondition condition);
	
	ResponseBookDetailDto queryBookDetail(int bookId);
}
