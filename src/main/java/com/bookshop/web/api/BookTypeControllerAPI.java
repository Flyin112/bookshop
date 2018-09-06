package com.bookshop.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.dto.RequestPageInfo;
import com.bookshop.dto.ResponsePageInfo;
import com.bookshop.dto.Result;
import com.bookshop.entity.BookType;
import com.bookshop.service.BookTypeService;

@Controller
@RequestMapping("/api/bookType")
public class BookTypeControllerAPI {

	@Autowired
	private BookTypeService bookTypeService;
	
	@RequestMapping({"/", "/list"})
	@ResponseBody
	private Result getAllBookTypes() {
		List<BookType> bookTypes = bookTypeService.queryBookTypes();
		return new Result(1, "查询成功", bookTypes);
	}
	
	@RequestMapping("/get")
	@ResponseBody
	private Result getBookTypes(RequestPageInfo requestPageInfo) {
		List<BookType> bookTypes = bookTypeService.queryBookTypes(requestPageInfo);
		int total = bookTypeService.queryCountForBookTypes();
		ResponsePageInfo<BookType> responsePageInfo = new ResponsePageInfo<BookType>(total, bookTypes);
		return new Result(1, "查询成功", responsePageInfo);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	private Result deleteBookType(Integer typeId) {
		if(bookTypeService.deleteBookType(typeId))
			return new Result(1, "删除成功", null);
		return new Result(0, "删除失败", null);
	}
	
	
}
