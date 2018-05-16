package com.lj.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;
import com.lj.ssm.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	//@Resource也可以用
	@Autowired
	private UserService userService;
	
	/**
	 * 用户列表页面
	 * 	返回值为ModelAndView
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping("/user_list")
	public ModelAndView user_list(HttpServletRequest request) throws Exception {
		ModelAndView view = new ModelAndView("user/user_list");
		
		//测试下面方法中的返回  forward:
		System.out.println(request.getParameter("id"));
		
		UserCustom userCustom = new UserCustom();
		UserVo userVo = new UserVo();
		userVo.setUserCustom(userCustom);
		List<UserCustom> userList = userService.findUserByCondition(userVo);
		view.addObject("userList", userList);
		return view;
	}
	
	
	
	// 知识点总结：
	// 	一.返回值主要有三种类型
	//		1.ModelAndView  
	//		2.String - 使用Model或其他参数等方法传值到前台   
	//		3.void - 可用于返回json等
	
	/**
	 * 跳转到编辑用户页面
	 * 	1.用参数Model传值
	 * 	2.返回值为string
	 * @param model
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping("/user_openToEdit")
	public String user_openToEdit(Model model) throws Exception {
		
		UserCustom userCustom = userService.findUserById(1);
		model.addAttribute("userCustom", userCustom);
		
		return "user/user_edit";
	}
	
	/**
	 * 跳转到编辑用户页面
	 * 	1.指定为post
	 * 	2.重定向/转发
	 * @param model
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping(value="/user_edit",method={RequestMethod.POST})
	public String user_edit(HttpServletRequest request) throws Exception {
		//UserCustom userCustom = userService.updateUser(id, userCustom);
		
		//转发
		return "forward:user_list";
		//重定向
		//return "redirect:user_list";
	}
}
