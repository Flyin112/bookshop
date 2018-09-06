package com.bookshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/background/bookType")
public class BookTypeController{
	
	@RequestMapping("/list")
	public String getList() {
		return "background_booktype";
	}
}