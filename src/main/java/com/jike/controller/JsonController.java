package com.jike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.bean.User;

@Controller
public class JsonController {

	@ResponseBody
	@RequestMapping("getJson")
	public User getUserInfo() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		return user;
	}
}
