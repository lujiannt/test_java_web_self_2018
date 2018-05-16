package com.lj.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	// 	一.返回值（主要有三种类型）
	//		1.ModelAndView  
	//		2.String - 使用Model或其他参数等方法传值到前台   
	//		3.void - 可用于返回json等
	//	二.参数绑定
	//		1.默认支持的参数 （springMvc在前端控制器中已经获得到这些参数，如在servletDispatcher中已经获得request，它可以直接赋值到方法中）
	//   		①httpServletRequst 
	//   		②httpServletResponse 
	//  		③HttpSession 
	//   		④Model/ModelMap
	//   	2.简单参数（springMvc自带很多类型转换器组件，对于简单类型转换没问题）
	//			①当请求参数和这里方法中形参名一样时，可以直接获取
	//  		②当形参名与请求参数不一致时，使用该注解：@RequestParam（还有校验和赋予默认值的功能）
	// 				value  请求参数名
	// 				required 可不可空
	//   			defaultValue 默认值
	//  		③当形参名与请求参数不一致时，也使用该注解：@PathVariable
	//		3.pojo类	
	//			字段名对应时，会自动映射
	//		4.自定义参数绑定转换器
	//			①springMvc配置文件中配置:
	//
	//				<mvc:annotation-driven conversion-service="conversionService"/>
	//			
	//				<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
	//					<property name="converters">
	//						<list>
	//							<bean class="com.lj.ssm.controller.converter.CustomDateConverter"/>
	//						</list>
	//					</property>
	//				</bean>
	//
	//			②自定义参数绑定转换器代码:
	//
	//			public class CustomDateConverter implements Converter<String, Date>{
	//				@Override
	//				public Date convert(String res) {
	//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//					try {
	//						return sdf.parse(res);
	//					} catch (ParseException e) {
	//						e.printStackTrace();
	//					}
	//					return null;
	//				}
	//			}
	//
	//	三.springMvc和Struts2的区别
	//	springMvc:	
	//		1.springMvc是基于方法的开发
	//			通过url和controller映射，创建一个controller，并且只有一个方法
	//		2.springMvc是通过方法形参接受参数（和service开发类似），方法结束会销毁，所以可以使用单例模式
	//	struts2:
	//		1.struts2是基于类的开发
	//			生成的action中含有很多东西
	//		2.通过action中的成员变量和get/set获取请求参数，而成员变量是共享的，所以只能用多例模式
	//
	//
	
	
	/**
	 * 跳转到编辑用户页面
	 * 	1.用参数Model传值
	 * 	2.返回值为string
	 *  3.默认支持的参数 （springMvc在前端控制器中已经获得到这些参数，如在servletDispatcher中已经获得request，它可以直接赋值到方法中）
	 *  	①httpServletRequst 
	 *  	②httpServletResponse 
	 *  	③HttpSession 
	 *  	④Model/ModelMap
	 *  4.简单参数（springMvc自带很多类型转换器组件，对于简单类型转换没问题）
	 *  	①当请求参数和这里方法中形参名一样时，可以直接获取
	 *  	②当形参名与请求参数不一致时，使用该注解：@RequestParam（还有校验和赋予默认值的功能）
	 *  		value  请求参数名
	 *  		required 可不可空
	 *  		defaultValue 默认值
	 *  	③当形参名与请求参数不一致时，也使用该注解：@PathVariable
	 * @param model
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping("/user_openToEdit")
	//1.请求参数和这里方法中形参名一样时:
	//public String user_openToEdit(Model model, int id) throws Exception {
	//2.请求参数和这里方法中形参名不一样时-@RequestParam
	public String user_openToEdit(Model model, @RequestParam(value="id", required=true, defaultValue="1") int userId) throws Exception {
		
		UserCustom userCustom = userService.findUserById(userId);
		model.addAttribute("userCustom", userCustom);
		
		return "user/user_edit";
	}
	
	/**
	 * 跳转到编辑用户页面
	 * 	1.指定为post
	 * 	2.重定向/转发
	 *  3.接受pojo类参数
	 *  4.自定义参数绑定器
	 *  	当页面注释掉createTime时，可以更新；当放开后，会报错，因为springMvc的转换器无法转换date
	 *  	--因为date格式多样，如yyyy-MM-dd或者yyyy/MM/dd，springMvc无法确定
	 *  	所以需要自定义一个Date转换器
	 *  		拓展有时候也会创建去掉字符串前后空格的转换器
	 * @param model
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping(value="/user_edit",method={RequestMethod.POST})
	public String user_edit(HttpServletRequest request, Integer id, UserCustom userCustom) throws Exception {
		
		userService.updateUser(id, userCustom);

		//转发
		return "forward:user_list";
		//重定向
		//return "redirect:user_list";
	}
}
