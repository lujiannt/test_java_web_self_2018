package com.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterCeptor2 implements HandlerInterceptor{

	/**
	 * 在处理请求之前
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2017年1月14日
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("MyInterCeptor2 preHandle:  在处理请求之前");
		return true;
	}

	/**
	 * 执行完方法后  渲染视图前
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @author lujian
	 * @create 2017年1月14日
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterCeptor2 postHandle:  执行完方法后  渲染视图前");
	}

	/**
	 * 渲染视图后
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @author lujian
	 * @create 2017年1月14日
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterCeptor2 afterCompletion:  渲染视图后");
	}

}
