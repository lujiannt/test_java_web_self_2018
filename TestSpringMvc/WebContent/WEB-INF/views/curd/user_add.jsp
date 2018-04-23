<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String BasePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<title>Insert title here</title>
</head>
<body>
 <h1>${title }</h1>
 <form action="<%=BasePath %>curd/curd_user" method="post">
	 <table border="1">
	 	<thead>
	 		<tr>
	 			<th>ID</th>
	 			<th>名称</th>
	 			<th>年龄</th>
	 		</tr>
	 	</thead>
	 	
	 	<tr>
	 		<td><input type="text" name="userId" value=""></td>
	 		<td><input type="text" name="name" value=""></td>
	 		<td><input type="text" name="age" value=""></td>
	 	</tr>
	 	
	 	<tr>
	 		<td colspan="3">
	 			<input type="submit" value="提交">
	 		</td>
	 	</tr>
	 </table>
 </form>
</body>
</html>