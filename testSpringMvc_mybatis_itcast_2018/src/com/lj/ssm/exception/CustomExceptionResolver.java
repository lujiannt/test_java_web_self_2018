package com.lj.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author lujian
 * @create 2018年5月29日
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/**
	 * 解析异常并注入自定义异常类中 
	 * @param req
	 * @param res
	 * @param obj
	 * @param ex
	 * @return
	 * @author lujian
	 * @create 2018年5月29日
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj,
			Exception ex) {
		ModelAndView modelAndView = new ModelAndView("user/error");
		CustomException customException = null; 
		
		if(ex instanceof CustomException) {
			customException = (CustomException)ex;
		}else {
			customException = new CustomException(ex.getClass().getName());
		}
		
		modelAndView.addObject("errMsg", customException.getMessgae());
		return modelAndView;
	}
}
