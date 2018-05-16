package com.lj.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;
import com.lj.ssm.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findUserByCondition")
	public ModelAndView findUserByCondition() throws Exception {
		ModelAndView view = new ModelAndView("user/user_list");
		
		UserCustom userCustom = new UserCustom();
		UserVo userVo = new UserVo();
		userVo.setUserCustom(userCustom);
		List<UserCustom> userList = userService.findUserByCondition(userVo);
		view.addObject("userList", userList);
		return view;
	}
}
