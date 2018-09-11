package com.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.SQL.PageInfoForSQL;
import com.bookshop.dao.BookTypeDao;
import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.BookType;
import com.bookshop.service.BookTypeService;

@Service
public class BookTypeServiceImpl implements BookTypeService {
	
	@Autowired
	private BookTypeDao bookTypeDao;

	@Override
	public boolean addBookType(BookType bookType) {
		return bookTypeDao.addBookType(bookType) == 1 ? true : false;
	}

	@Override
	public boolean deleteBookType(int typeId) {
		return bookTypeDao.deleteBookType(typeId) == 1 ? true : false;
	}

	@Override
	public boolean updateBookType(BookType bookType) {
		return bookTypeDao.updateBookType(bookType) == 1 ? true : false;
	}

	@Override
	public BookType queryBookType(int typeId) {
		return bookTypeDao.queryBookType(typeId);
	}

	@Override
	public ResponsePageInfo<BookType> queryBookTypes(RequestPageInfo page) {
		List<BookType> bookTypes = bookTypeDao.queryBookTypes(new PageInfoForSQL(page));
		int total = bookTypeDao.queryCountForBookTypes();
		ResponsePageInfo<BookType> responsePageInfo = new ResponsePageInfo<BookType>(total, bookTypes);
		return responsePageInfo;
	}

	@Override
	public List<BookType> queryBookTypes() {
		return bookTypeDao.queryBookTypes(new PageInfoForSQL());
	}

}
