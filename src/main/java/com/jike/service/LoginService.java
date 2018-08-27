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
			throw new Exception("�û�������Ϊ��");
		}

		if (password == null || "".equals(password)) {
			throw new Exception("���벻��Ϊ�գ�");
		}

		User user = dao.selectByUserName(username);
		if (user == null) {
			throw new Exception("�û��������ڣ�");
		}

		if (!user.getUsername().equals(username) || !user.getPassword().equals(password)) {
			throw new Exception("�û������������");
		}

		return user;
	}

}
