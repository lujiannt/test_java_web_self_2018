<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="hello.action?birth=1998-1/9">hello</a>
<s:fielderror/>
<form action="va.action" method="post">
	
	<input type="text" name="username"><s:fielderror name="username.message"/><br>
	<input type="submit" value="提交">
</form>
<s:fielderror fieldName="username.message"/>

</body>
</html>