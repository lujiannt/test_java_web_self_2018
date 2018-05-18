<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
function editBatch(){
	document.itemsForm.submit();
}
</script>
</head>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/user/user_editBatch" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td>
商品名称：<input name="itemsCustom.name" />
</td>
<input type="button" value="批量修改提交" onclick="editBatch()"/>
</td>
</tr>
</table>
用户列表：
<table width="100%" border=1>
<tr>
	<td>用户名</td>
	<td>年龄</td>
	<td>注册日期</td>
</tr>
<c:forEach items="${userList }" var="user" varStatus="status">
<tr>	
	<input type="hidden" name="userList[${status.index }].id" value="${user.id }">
	<td><input name="userList[${status.index }].userName" value="${user.userName }"/></td>
	<td><input name="userList[${status.index }].age" value="${user.age }"/></td>
	<td><input name="userList[${status.index }].createTime" value="<fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
</tr>
</c:forEach>

</table>
</form>
</body>

</html>