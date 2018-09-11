package com.bookshop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.SQL.BookQueryCondition;
import com.bookshop.SQL.PageInfoForSQL;
import com.bookshop.dao.BookInfoDao;
import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.RequestQueryCondition;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.BookInfo;
import com.bookshop.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookInfoDao bookInfoDao;

	@Override
	public boolean addBook(BookInfo bookInfo) {
		return bookInfoDao.addBook(bookInfo) == 1 ? true : false;
	}

	@Override
	public boolean updateBook(BookInfo bookInfo) {
		return bookInfoDao.updateBook(bookInfo) == 1 ? true : false;
	}

	@Override
	public BookInfo queryBookInfo(int bookId) {
		return bookInfoDao.queryBookById(bookId);
	}

	@Override
	public ResponsePageInfo<BookInfo> queryAllBookInfoByAdmin(RequestPageInfo page) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("page", new PageInfoForSQL(page));
		List<BookInfo> rows = bookInfoDao.queryBook(queryMap);
		int total = bookInfoDao.queryBookCount(null);
		ResponsePageInfo<BookInfo> responsePageInfo = new ResponsePageInfo<>(total, rows);
		return responsePageInfo;
	}

	@Override
	public ResponsePageInfo<BookInfo> queryBookInfo(RequestQueryCondition condition) {
		BookQueryCondition bookQueryCondition = new BookQueryCondition(condition);
		PageInfoForSQL pageInfoForSQL = new PageInfoForSQL(condition.getPage());
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("condition", bookQueryCondition);
		queryMap.put("page", pageInfoForSQL);
		List<BookInfo> rows = bookInfoDao.queryBook(queryMap);
		int total = bookInfoDao.queryBookCount(bookQueryCondition);
		ResponsePageInfo<BookInfo> responsePageInfo = new ResponsePageInfo<>(total, rows);
		return responsePageInfo;
	}

}
