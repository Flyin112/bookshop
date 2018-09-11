package com.bookshop.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.bookshop.dto.Result;

public class BingResultUtil {

	public static Result checkBingResult(BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			for(ObjectError error : bindingResult.getAllErrors())
				errors.add(error.getDefaultMessage());
			return new Result(0, "参数错误", errors);
		}
		return null;
	}
}
