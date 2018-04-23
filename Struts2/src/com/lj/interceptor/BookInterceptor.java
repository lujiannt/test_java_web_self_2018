package com.lj.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BookInterceptor extends MethodFilterInterceptor{


	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("do inteceptor");
		
		return null;
	}

}
