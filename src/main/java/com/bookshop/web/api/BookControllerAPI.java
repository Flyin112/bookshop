package com.bookshop.web.api;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.RequestQueryCondition;
import com.bookshop.dto.ResponseBookDetailDto;
import com.bookshop.dto.Result;
import com.bookshop.entity.BookInfo;
import com.bookshop.service.BookService;

@Controller
@RequestMapping("/api/book")
public class BookControllerAPI {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Result addBook(@Validated BookInfo bookInfo) {
		if(bookService.addBook(bookInfo))
			return new Result(1, "添加成功", null);
		return new Result(0, "添加失败", null);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Result updateBook(@Validated BookInfo bookInfo) {
		if(bookService.updateBook(bookInfo))
			return new Result(1, "修改成功", null);
		return new Result(0, "修改失败", null);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Result queryAllBookByAdmin(@Validated RequestPageInfo page) {
		return new Result(1, "查询成功", bookService.queryAllBookInfoByAdmin(page));
	}
	
	@RequestMapping("/detailAdmin")
	@ResponseBody
	public Result queryBookByIdAdmin(@Min(1) int bookId) {
		BookInfo bookInfo = bookService.queryBookInfo(bookId);
		if(bookInfo != null)
			return new Result(1, "查询成功", bookInfo);
		return new Result(1, "查询不到此图书", null);
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public Result searchBook(@RequestBody @Validated RequestQueryCondition condition) {
		return new Result(1, "查询成功", bookService.queryBookInfo(condition));
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public Result getbookDetail(@Min(1) int bookId) {
		ResponseBookDetailDto bookInfo = bookService.queryBookDetail(bookId);
		if(bookInfo != null)
			return new Result(1, "查询成功", bookInfo);
		return new Result(1, "查询不到此图书", null);
	}
}
