package com.jike.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jike.bean.User;
import com.jike.dao.UserDao;

@Service
public class LoginService {

	@Resource
	UserDao dao;

	public User doLogin(String username, String password) throws Exception {

		if (username == null || "".equals(username)) {
			throw new Exception("用户名不能为空");
		}

		if (password == null || "".equals(password)) {
			throw new Exception("密码不能为空！");
		}

		User user = dao.selectByUserName(username);
		if (user == null) {
			throw new Exception("用户名不存在！");
		}

		if (!user.getUsername().equals(username) || !user.getPassword().equals(password)) {
			throw new Exception("用户名或密码错误！");
		}

		return user;
	}

}
