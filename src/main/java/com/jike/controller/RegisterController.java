package com.jike.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jike.bean.User;

@Controller
public class RegisterController {

	@Resource
	HttpServletRequest request;

	@RequestMapping("register")
	public String toRegisterPage() {
		return "register.jsp";
	}

	@RequestMapping(value = "doRegister", method = RequestMethod.POST)
	public String doRegister(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			List<FieldError> fields = result.getFieldErrors();
			for (FieldError field : fields) {
				request.setAttribute("ERR_" + field.getField(), field.getDefaultMessage());
			}
			return "register.jsp";
		}

		// Ê¡ÂÔ×¢²áÂß¼­

		return "success.jsp";
	}
}
