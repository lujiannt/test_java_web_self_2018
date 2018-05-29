package com.lj.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lj.ssm.model.UserCustom;

@Controller
public class TestJsonController {
	
	@RequestMapping("requestJson1")
	@ResponseBody
	public UserCustom requestJson1(@RequestBody UserCustom userCustom) {
		return userCustom;
	}
	
	@RequestMapping("requestJson2")
	@ResponseBody
	public UserCustom requestJson2(UserCustom userCustom) {
		return userCustom;
	}
	
}
