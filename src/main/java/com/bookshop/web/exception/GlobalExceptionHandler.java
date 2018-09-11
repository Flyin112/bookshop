package com.bookshop.web.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.dto.Result;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(SystemException.class)
	@ResponseBody
	public Result customHandler(SystemException e) {
		return new Result(e.getCode(), e.getMessage(), null);
	}
	
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Result notValidExceptionHandler(BindException e) {
		List<String> errors = new ArrayList<String>();
		for(ObjectError error : e.getBindingResult().getAllErrors()) {
			errors.add(error.getDefaultMessage());
		}
		return new Result(0, "参数错误", errors);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result exceptionHandler(Exception e) {
		return new Result(0, e.toString(), null);
	}
}
