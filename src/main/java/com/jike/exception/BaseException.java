package com.jike.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseException {

	@ExceptionHandler(MyException.class)
	public String handle(Exception ex, HttpServletRequest request) {
		request.setAttribute("error", ex.getMessage());
		return "exception.jsp";
	}
}
