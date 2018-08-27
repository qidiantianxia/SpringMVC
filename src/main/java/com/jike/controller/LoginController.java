package com.jike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jike.bean.User;
import com.jike.constant.Global;
import com.jike.exception.BaseException;
import com.jike.exception.MyException;
import com.jike.service.LoginService;

@Controller
public class LoginController extends BaseException {

	@Resource
	LoginService service;

	HttpServletRequest request;

	@RequestMapping("exception")
	public void MyException() throws Exception {
		throw new MyException("¥•∑¢“Ï≥£≤‚ ‘");
	}

	/*@RequestMapping("login")
	public String toLoginPage() {
		return "login.jsp";
	}*/

	@RequestMapping(value = "user/home")
	public String toUserHome() {
		return "/user/home.jsp";
	}

	/*@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
			ModelMap map) {

		String url = "";

		try {
			User user = service.doLogin(username, password);
			request.getSession().setAttribute(Global.USER_SESSION_KEY, user);
			url = "/user/home.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			url = "login.jsp";
		}

		return url;
	}*/

}
