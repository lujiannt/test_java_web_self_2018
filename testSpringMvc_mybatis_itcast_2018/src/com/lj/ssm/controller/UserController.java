package com.lj.ssm.controller;

import java.security.acl.Group;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lj.ssm.exception.CustomException;
import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;
import com.lj.ssm.service.UserService;
import com.lj.ssm.validate.group.ValidateGroup1;
import com.lj.ssm.validate.group.ValidateGroup2;

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
	public ModelAndView user_list(HttpServletRequest request, UserVo userVo) throws Exception {
		ModelAndView view = new ModelAndView("user/user_list");
		
		//测试下面方法中的返回  forward:
		//System.out.println(request.getParameter("id"));
		
		List<UserCustom> userList = userService.findUserByCondition(userVo);
		view.addObject("userList", userList);
		view.addObject("userVo", userVo);
		return view;
	}
	
	
	
	// 知识点总结：
	// 	一.返回值（主要有三种类型）
	//		1.ModelAndView  
	//		2.String - 使用Model或其他参数等方法传值到前台   
	//		3.void - 可用于返回json等
	//		4.Map
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
	//		5.参数校验
	//  		1.加入jar包（这里使用的是hibernate的校验jar包）
	//	  		2.springmVC配置文件中配置校验器validater，添加并配置自定义错误文件CustomValidationMessages.properties
	//	  		3.对应model加校验注解
	//	  		4.controller方法中在对应model前加@Validated，并且新增参数BindingResult，要注意他们是配对的缺一不可
	//	  		5.校验分组，新建对应分组接口（无需写内容），在model里的校验注解中配置分组，在controller方法中配置分组（经过测试，如果校验器都有分组，这里方法中不配置分组的话，默认不校验）
	//		6.值的回显
	//		 	1.除了modelAndView、Model、ModelMap、request中添加值，方法的参数也可以直接回显
	//		 	2.当方法参数名和页面上不一致时，使用@ModelAttribute注解，来指定request域中的属性key值	
	//		7.自定义全局异常处理器和自定义异常类
	//			1.自定义全局异常处理器需要实现HandlerExceptionResolver接口，在springMvc配置文件中配置一下bean即可（需要注意方法中的解析异常的逻辑）
	//			2.自定义异常类只需继承exception类即可
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
	 * 编辑用户
	 * 	1.指定为post
	 * 	2.重定向/转发
	 *  3.接受pojo类参数
	 *  4.自定义参数绑定器
	 *  	当页面注释掉createTime时，可以更新；当放开后，会报错，因为springMvc的转换器无法转换date
	 *  	--因为date格式多样，如yyyy-MM-dd或者yyyy/MM/dd，springMvc无法确定
	 *  	所以需要自定义一个Date转换器
	 *  		拓展有时候也会创建去掉字符串前后空格的转换器
	 *  5.参数校验
	 *  	1.加入jar包（这里使用的是hibernate的校验jar包）
	 *  	2.springmVC配置文件中配置校验器validater，添加并配置自定义错误文件CustomValidationMessages.properties
	 *  	3.对应model加校验注解
	 *  	4.controller方法中在对应model前加@Validated，并且新增参数BindingResult，要注意他们是配对的缺一不可
	 *  	5.校验分组，新建对应分组接口（无需写内容），在model里的校验注解中配置分组，在controller方法中配置分组（经过测试，如果校验器都有分组，这里方法中不配置分组的话，默认不校验）
	 *  6.值的回显
	 *  	1.除了modelAndView、Model、ModelMap、request中添加值，方法的参数也可以直接回显
	 *  	2.当方法参数名和页面上不一致时，使用@ModelAttribute注解，来指定request域中的属性key值	
	 *  	3.简单类型数据回显默认用不了，不能在页面上注解${id}获取
	 *  7.自定义全局异常处理器和自定义异常类
	 *  	1.自定义全局异常处理器需要实现HandlerExceptionResolver接口，在springMvc配置文件中配置一下bean即可（需要注意方法中的解析异常的逻辑）
	 *  	2.自定义异常类只需继承exception类即可
	 * @param model
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping(value="/user_edit",method={RequestMethod.POST})
	public String user_edit(HttpServletRequest request, Model model, Integer id,
							@ModelAttribute("userCustom") @Validated(value={ValidateGroup1.class, ValidateGroup2.class}) UserCustom userCustom, 
							BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			for(ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("errors", bindingResult.getAllErrors());
			
			return "forward:user_openToEdit?id="+id;
		}else {
			//测试全局异常处理器和自定义异常捕获
			if(userCustom.getUserName().equals("毛泽东")) {
				throw new CustomException("名称不合法");
			}
			//测试系统异常
			//userCustom = null;
			//id = -1;
			userService.updateUser(id, userCustom);
		}
		
		return "user/user_edit";
		//转发
		//return "forward:user_list";
		//重定向
		//return "redirect:user_list";
	}
	
	/**
	 * 批量逻辑删除_数组
	 * 	注意:这边要注意xml中 parameterType 和 conllection的写法
	 * @param ids
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping(value="/user_deleteBatch")
	public String user_deleteBatch(int[] ids) throws Exception {
		if(ids.length > 0) {
			userService.deleteUserForBatch(ids);
		}

		//转发
		return "redirect:user_list";
	}
	
	/**
	 * 批量逻辑删除_list<Integer>
	 * 	注意:这边要注意xml中 parameterType 和 conllection的写法
	 * @param ids
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping(value="/user_deleteBatch_list")
	public String user_deleteBatch1(UserVo userVo) throws Exception {
		if(userVo.getIds() != null && userVo.getIds().size() > 0) {
			userService.deleteUserForBatch1(userVo);
		}
		
		//转发
		return "forward:user_list";
	}
	
	/**
	 * 跳转到批量编辑用户页面_list<UserCustom>
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping("/user_openToEditBatch")
	public ModelAndView user_openToEditBatch() throws Exception {
		ModelAndView view = new ModelAndView("user/user_editBatch");
		
		List<UserCustom> userList = userService.findUserByCondition(null);
		view.addObject("userList", userList);
		
		return view;
	}
	
	/**
	 * 批量编辑用户_list<UserCustom>
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@RequestMapping("/user_editBatch")
	public String user_editBatch(UserVo userVo) throws Exception {
		List<UserCustom> userlist = userVo.getUserList();
		if(userlist.size() > 0) {
			for(UserCustom userCustom : userlist) {
				userService.updateUser(userCustom.getId(), userCustom);
			}
		}
		
		return "user/success";
	}
}
