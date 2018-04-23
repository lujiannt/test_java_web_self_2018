package com.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.dao.UserDao;
import com.test.model.User;

@Controller
@RequestMapping("/curd")
public class CurdController {
	//@Autowired自动装载对象userDao，
	//它会在所有@Repository注解的类里面找对应名称或类型的类,这个估计是找类型(按名称找，应该是配置文件中，而且要有getset)
	@Autowired
	private UserDao userDao;
	
	//之前用ModelAndView传递数据，其实在spring mvc 中参数在前台request中也可以接受到
	@RequestMapping("/listUser")
	public String listUser(Map<String, Object> map) {
		map.put("users", userDao.getUsers());
		return "curd/user_list";
	}
	
	/**
	 * 跳转到添加user
	 * 经过测试，如果参数里是 String title，那么前台是接受不到的，必须是map,或者model（其实相当于map）
	 * @return
	 * @author lujian
	 * @create 2017年5月9日
	 */
	@RequestMapping("/curd_user")
	public String openToAddUser(Model model) {
		String title = "添加用户";
		model.addAttribute("title",title);
		return "curd/user_add";
	}
	
	/**
	 * 添加user
	 * 这里用到了重定向
	 * redirect:/  + url
	 * @return
	 * @author lujian
	 * @create 2017年5月9日
	 */
	@RequestMapping(value="/curd_user", method=RequestMethod.POST)
	public String curd_user(User user) {
		userDao.saveUser(user);
		return "redirect:/curd/listUser";
	}
	
	/**
	 * 添加user
	 * 这里用到了重定向
	 * redirect:/  + url
	 * @return
	 * @author lujian
	 * @create 2017年5月9日
	 */
	@RequestMapping(value="/curd_user/{userId}", method=RequestMethod.DELETE)
	public String curd_user(@PathVariable("userId")int userId) {
		userDao.deleteUser(userId);
		return "redirect:/curd/listUser";
	}
}
