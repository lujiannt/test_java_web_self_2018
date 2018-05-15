package com.lj.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lj.model.User;

public class UserController_01 implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView();
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "张三", 11, new Date()));
		userList.add(new User(2, "李四", 21, new Date()));
		userList.add(new User(3, "王五", 31, new Date()));
		
		view.addObject(userList);
		view.setViewName("/WEB-INF/jsp/user/user_list.jsp");
		return view;
	}

}
