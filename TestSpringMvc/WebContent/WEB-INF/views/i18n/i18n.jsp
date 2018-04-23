<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String BasePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>I18n-中文</title>
</head>
<body>
	<a href="<%=BasePath %>i18/testI18n_1?locale=zh_CN">中文</a>
	<a href="<%=BasePath %>i18/testI18n_1?locale=en_US">English</a>
	<fmt:message key="username"></fmt:message>
	<!-- <mvc:view-controller path="/i18n2" view-name="username"/>  -->
</body>
</html>