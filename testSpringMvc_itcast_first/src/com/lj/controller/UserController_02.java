package com.lj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.lj.model.User;

public class UserController_02 implements HttpRequestHandler{
	
	/**
	 * 这种方法可以处理返回json格式等特殊要求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @author lujian
	 * @create 2018年5月15日
	 */
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "张三", 11, new Date()));
		userList.add(new User(2, "李四", 21, new Date()));
		userList.add(new User(3, "王五", 31, new Date()));
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/jsp/user/user_list.jsp").forward(request, response);
	}


}
