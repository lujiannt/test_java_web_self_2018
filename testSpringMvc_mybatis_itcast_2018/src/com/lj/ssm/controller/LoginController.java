package com.lj.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	/**
	 * 测试登录拦截器，只是简单的逻辑_登录
	 * @param userName
	 * @return
	 * @author lujian
	 * @create 2018年5月30日
	 */
	@RequestMapping("login")
	public String testLogin(HttpSession session, String userName) {
		if(StringUtils.isNotBlank(userName)) {
			session.setAttribute("userName", userName);
			
			return "redirect:user/user_list";
		}
		
		return "redirect:/WEB-INF/jsp/login.jsp";
	}

	/**
	 * 测试登录拦截器，只是简单的逻辑_登出
	 * @param userName
	 * @return
	 * @author lujian
	 * @create 2018年5月30日
	 */
	@RequestMapping("logout")
	public String testLogout(HttpSession session, String userName) {
		session.invalidate();
		return "redirect:user/user_list";
	}
}
