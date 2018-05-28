<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body> 
<!-- 显示错误信息 -->
<c:if test="${errors!=null }">
	<c:forEach items="${errors }" var="error">
	${ error.defaultMessage}<br/>
</c:forEach>
</c:if>

<form id="itemForm" action="${pageContext.request.contextPath }/user/user_edit" method="post" ><!-- enctype="multipart/form-data" -->
<input type="hidden" name="id" value="${userCustom.id }"/>
修改用户信息：
<table width="100%" border=1>
<tr>
	<td>名称${id }</td>
	<td><input type="text" name="userName" value="${userCustom.userName }"/></td>
</tr>
<tr>
	<td>性别</td>
	<td><input type="text" name="age" value="${userCustom.age }"/></td>
</tr>

<tr>
	<td>注册日期</td>
	<td><input type="text" name="createTime" value="<fmt:formatDate value="${userCustom.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
</tr>
<%--
 <tr>
	<td>商品图片</td>
	<td>
		<c:if test="${items.pic !=null}">
			<img src="/pic/${items.pic}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file"  name="items_pic"/> 
	</td>
</tr> 
<tr>
	<td>商品简介</td>
	<td>
	<textarea rows="3" cols="30" name="detail">${items.detail }</textarea>
	</td>
</tr>--%>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>