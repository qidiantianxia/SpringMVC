package com.jike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jike.common.RandomValidateCode;
import com.jike.constant.Constants;

@Controller
public class ToolController {

	@RequestMapping("topage")
	public String toPage(@RequestParam String pagename) {
		System.out.println("topage:" + pagename);
		return pagename;
	}

	@RequestMapping("doLogin")
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam String vcode) {
		String url = "";
		String sessionCode = (String) request.getSession().getAttribute(Constants.RANDOM_CODE_KEY);
		if (vcode.equals(sessionCode)) {
			url = "i18n";
		} else {
			request.setAttribute("error", "ÑéÖ¤Âë´íÎó");
			url = "login";
		}

		return url;
	}

	@Resource
	RandomValidateCode code;

	@RequestMapping("vcode")
	public void vcode(HttpServletRequest request, HttpServletResponse response) {
		code.getRandcode(request, response);
	}
}
