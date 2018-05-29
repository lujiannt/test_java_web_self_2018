<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function testJson1() {
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/requestJson1',
			//contentType需要设置成json格式
			contentType:'application/json;charset=utf-8',
			data:'{"userName":"手机","age":999}',
			success:function(data){//返回json结果
				alert(data);
			}
		});
	}
	
	function testJson2() {
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/requestJson2',
			data:'{"userName":"手机","age":999}',
			success:function(data){//返回json结果
				alert(data);
			}
		});
	}
	
	//经过测试$.post相当于testJson2方法。是key/value请求，不是json请求
	function testJson3() {
		$.post(
			"requestJson2",
			{"userName":"张三","age":11},
			function(data){
				alert(data);
			},"json"
		);
	}
</script>
</head>
<body>
	<input type="button" value="发送json格式请求，响应json结果" onclick="testJson1()">
	<input type="button" value="发送key/value格式请求，响应json结果" onclick="testJson2()">
	<input type="button" value="$.post发送，响应json结果" onclick="testJson3()">
</body>
</html>