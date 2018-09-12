package com.bookshop.service.impl;

import java.util.ArrayList;
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
import com.bookshop.dto.ResponseBookDetailDto;
import com.bookshop.dto.ResponseSearchBookDto;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.entity.BookInfo;
import com.bookshop.service.BookService;
import com.bookshop.utils.FormatUtil;

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
	public ResponsePageInfo<ResponseSearchBookDto> queryBookInfo(RequestQueryCondition condition) {
		BookQueryCondition bookQueryCondition = new BookQueryCondition(condition);
		PageInfoForSQL pageInfoForSQL = new PageInfoForSQL(condition.getPage());
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("condition", bookQueryCondition);
		queryMap.put("page", pageInfoForSQL);
		List<BookInfo> books = bookInfoDao.queryBook(queryMap);
		List<ResponseSearchBookDto> rows = new ArrayList<ResponseSearchBookDto>();
		for(BookInfo bookInfo : books) {
			ResponseSearchBookDto responseBookDto = new ResponseSearchBookDto();
			responseBookDto.setBookId(bookInfo.getBookId());
			responseBookDto.setBookName(bookInfo.getBookName());
			responseBookDto.setPublisher(bookInfo.getPublisher());
			responseBookDto.setIntroduction(bookInfo.getIntroduction());
			responseBookDto.setPrice(bookInfo.getPrice().stripTrailingZeros().toPlainString());
			rows.add(responseBookDto);
		}
		int total = bookInfoDao.queryBookCount(bookQueryCondition);
		ResponsePageInfo<ResponseSearchBookDto> responsePageInfo = new ResponsePageInfo<>(total, rows);
		return responsePageInfo;
	}

	@Override
	public ResponseBookDetailDto queryBookDetail(int bookId) {
		BookInfo bookInfo = queryBookInfo(bookId);
		ResponseBookDetailDto responseBookDetailDto = new ResponseBookDetailDto();
		responseBookDetailDto.setBookId(bookInfo.getBookId());
		responseBookDetailDto.setBookName(bookInfo.getBookName());
		responseBookDetailDto.setPublisher(bookInfo.getPublisher());
		responseBookDetailDto.setIntroduction(bookInfo.getIntroduction());
		responseBookDetailDto.setPrice(bookInfo.getPrice().stripTrailingZeros().toPlainString());
		responseBookDetailDto.setPublishTime(FormatUtil.dateToString(bookInfo.getPublishTime()));
		responseBookDetailDto.setISBN(bookInfo.getISBN13());
		responseBookDetailDto.setStoreNum(bookInfo.getRealStoreNum());
		responseBookDetailDto.setTypeId(bookInfo.getTypeId());
		return responseBookDetailDto;
	}

	@Override
	public Map<String, Object> queryBookNeedNum(int bookId) {
		Map<String, Object> map = bookInfoDao.queryBookNeedNum(bookId);
		return map;
	}

}
