package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping(value="/i18")
@Controller
public class I18nController {
	
	@RequestMapping("/testI18n_1")
	public String testI18n1() {
		System.out.println(1);
		return "i18n/i18n";
	}
}
