package com.lj.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试登录验证
 * @author lujian
 * @create 2018年5月30日
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * 方法结束前（用于校验权限等等）
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月30日
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		String userName = (String) session.getAttribute("userName");
		
		if(uri.indexOf("login") >= 0) {
			return true;
		}
		
		if(userName != null) {
			return true;
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, res);
		return false;
	}
	
	/**
	 * 进入方法后，return前（用于添加一些公共的操作等等）
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月30日
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
	}
	
	/**
	 * 进入方法后（用于添加日志等等）
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月30日
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
	}


}
