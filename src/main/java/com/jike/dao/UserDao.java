package com.jike.dao;

import org.springframework.stereotype.Repository;

import com.jike.bean.User;

@Repository
public class UserDao {

	public User selectByUserName(String username) {
		User user = null;
		if (username.equals("admin")) {
			user = new User();
			user.setUsername(username);
			user.setPassword("123456");

		}
		return user;
	}
}
