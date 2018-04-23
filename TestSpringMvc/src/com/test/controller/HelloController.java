package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	

	/**
		* 1. 使用RequestMapping注解来映射请求的URL
		* 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
		* 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
		* "/WEB-INF/views/success.jsp"
		* 
		* 地址栏输入访问地址链接默认是get  method=RequestMethod.GET
		* @return
	**/
	@RequestMapping(value="/helloworld")
	public String hello() {
		return "hello";
	}
}
