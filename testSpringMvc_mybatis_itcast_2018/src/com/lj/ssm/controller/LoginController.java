package com.lj.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;
import com.lj.ssm.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
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
			
//			return "redirect:user/user_list";
			return "forward:user/user_list";
		}
		
		return "login";
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
