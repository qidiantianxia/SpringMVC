package com.jike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.bean.User;

@Controller
public class PathvariableController {
	@ResponseBody
	@RequestMapping("/pathvariable/{username}")
	public User getUserInfo(@PathVariable String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("123456");
		return user;
	}

	@ResponseBody
	@RequestMapping("/pathvariable2/{username}")
	public User getUserInfo(@PathVariable Integer username) {
		User user = new User();
		user.setUsername(username + "");
		user.setPassword("123456");
		return user;
	}
}
