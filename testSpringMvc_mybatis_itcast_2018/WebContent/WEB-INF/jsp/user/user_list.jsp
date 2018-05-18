<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户品列表</title>
<!--引入官网js <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> -->
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function deleteBatch() {
		
		var size = $("input[name='ids']:checked").size();
		if(size >= 1) {
			document.myForm.action="${pageContext.request.contextPath }/user/user_deleteBatch";
			document.myForm.submit();
		}
		
		//jquery方法。这里没有引入js，就不用了
		//$("#myform").attr('action',newUrl);    //通过jquery为action属性赋值
       	//$("#myform").submit();    //提交ID为myform的表单
	}
	
	function deleteBatch1() {
		
		$("#myForm").attr('action',"${pageContext.request.contextPath }/user/user_deleteBatch_list");    //通过jquery为action属性赋值
       	$("#myForm").submit();    //提交ID为myform的表单
	}
	
	function modifyBatch1() {
		window.location.href="${pageContext.request.contextPath }/user/user_openToEditBatch"
	}
</script>

<style type="text/css">
</style>

</head>
<body> 
<form name="myForm" id="myForm" action="${pageContext.request.contextPath }/user/user_list" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td>姓名：<input value="${userVo.userCustom.userName }" name="userCustom.userName" /></td>
<td>年龄：<input value="${userVo.userCustom.age }" name="userCustom.age" /></td>
<td><input type="submit" value="查询"/>
<input type="button" value="批量删除_数组" onclick="deleteBatch()"/>
<input type="button" value="批量删除_list" onclick="deleteBatch1()"/>
<input type="button" value="批量修改_list" onclick="modifyBatch1()"/>
</td>

</tr>
</table>


商品列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>id</td>
	<td>名称</td>
	<td>年龄</td>
	<td>创建时间</td>
	<td>操作</td>
</tr>
<c:forEach items="${userList }" var="user">
<tr>
	<td><input type="checkBox" name="ids" value="${user.id }"></td>
	<td>${user.id }</td>
	<td>${user.userName }</td>
	<td>${user.age }</td>
	<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td><a href="${pageContext.request.contextPath }/user/user_openToEdit?id=${user.id }">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>