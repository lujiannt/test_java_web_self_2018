<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String BasePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=BasePath %>/js/jquery-1.8.1.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	function del(userId) {
		/* var xhr = new XMLHttpRequest();
		var url = "curd/curd_user/{userId}";
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.open("POST", url, true);
		
		xhr.onreadystatechange = function() {
			 if (xhr.readyState==4 && xhr.status==404) {
				    alert("Oh no, it does not exist!");
				  }
			
			if(xhr.status == 200 && xhr.readyState == 4) {
				var text = xhr.responseText;
				var user = eval("("+text+")");
				var htmlStr = '<a href="#">ajax json返回user ' + user.name + '</a><br>';
				document.getElementById("jsontext").innerHTML = htmlStr;
			}
		};
		xhr.send("_method=DELETE"); */
		
		$("#delForm").attr("action","<%=BasePath %>/curd/curd_user/"+userId);
		$("#delForm").submit();
		
		
	}
	
</script>
</head>
<body>
 <h1>用户列表</h1>
 <table border="1" cellpadding="10" cellspacing="0">
 	<thead>
 		<tr>
 			<th>ID</th>
 			<th>名称</th>
 			<th>年龄</th>
 			<th>操作</th>
 		</tr>
 	</thead>
 	<c:forEach items="${users }" var="u"> 
	 	<tr>
	 		<td>${u.userId }</td>
	 		<td>${u.name }</td>
	 		<td>${u.age }</td>
	 		<td><a onclick="del(${u.userId })">删除</a>
	 		</td>
	 	</tr>
	</c:forEach>
	<tr>
		
	</tr>
	<a href="<%=BasePath %>curd/curd_user">新增用户</a>	
	
	<form action="<%=BasePath %>curd/curd_user/1" method="post" id="delForm">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	
 </table>
</body>
</html>