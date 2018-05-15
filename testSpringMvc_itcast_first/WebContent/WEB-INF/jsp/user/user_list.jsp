<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/user/user_list" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>id</td>
	<td>名称</td>
	<td>年龄</td>
	<td>创建时间</td>
	<td>操作</td>
</tr>
<c:forEach items="${userList }" var="user">
<tr>
	<td>${user.id }</td>
	<td>${user.userName }</td>
	<td>${user.age }</td>
	<td><fmt:formatDate value="${user.creatTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	
	<td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>