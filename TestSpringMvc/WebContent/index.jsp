<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.1.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
	function addUser() {
		var xhr = new XMLHttpRequest();
		var url = "user/testJson1";
		xhr.open("GET", url, false);
		
		xhr.onreadystatechange = function() {
			if(xhr.status == 200 && xhr.readyState == 4) {
				var text = xhr.responseText;
				//alert(text);
				var user = eval("("+text+")");
				var htmlStr = '<a href="#">ajax json返回user ' + user.name + '</a><br>';
				document.getElementById("jsontext").innerHTML = htmlStr;
			}
		};
		xhr.send(null);
		
	}
	
	function addUser2() {
		$.post(
			"user/testJson2",
			{"userId":3},
			function(data){
				var errMsg = data.errMsg;
				var user = data[0];
				if(errMsg == null){
					var htmlStr = '<br><a href="#">postjson返回user: ' +user.userId +'  ' + user.name + '</a><br>';
					$("#josn3").append(htmlStr);
				} else {
					alert("删除失败，请重试");
				}
			},"json"
		);
	}
</script>

</head>
<body>
	<a href="helloworld">hello world</a><br>
	
	<a href="user/user_view/1,张三">链接传参1</a><br>
	<a href="user/user_view?name=zhangsan">链接传参2</a><br>
	<a href="user/user_view3?name=lisi&id=4">链接传参3</a><br>
	<a href="user/getCookieValue">获取cookieValue</a><br>
	<a href="user/getHeaderValue">获取RequestHeader中相关信息</a><br>
	<a href="user/testModelAndView/高锡">modelAndView测试</a><br>
	
	<h3>rest风格 - post（增）</h3>
	<form action="user/testrest/1" enctype="multipart/form-data" method="post">
		<input type="submit" value="提交">
	</form>
	
	<h3>rest风格 - delete（删）</h3>
	<form action="user/testrest/1" method="post" enctype="multipart/form-data">
		<input type="hidden" name="_method" value= "DELETE"/>
		<input type="submit" value="提交">
	</form>
	
	<h3>rest风格 - put（改）</h3>
	<form action="user/testrest/1" method="post">
		<input type="hidden" name="_method" value= "PUT"/>
		<input type="submit" value="提交">
	</form>
	
	<h3>rest风格 - get（查）</h3>
	<a href="user/testrest/1">rest风格 - get</a><br><br><br>
	
	<h3>（表单数据封装成POJO）POJO - 测试</h3>
	<form action="user/testPojo"  method="post" >
		名称:<input type="text" name="name"><br>
		年龄:<input type="text" name="age"><br>
		地址:<input type="text" name="address.address"><br>
		邮编:<input type="text" name="address.postCode"><br>
		<input type="submit" value="提交">
	</form>
	
	
	<br><br>
	<a href="user/testHtml1">多视图解析-html_hello1.html</a><br>
	<a href="user/testHtml2">多视图解析-hello2.html</a><br>
	<a href="user/testHtml3">多视图解析-testh_hello.html</a><br>
	
	
	<h3>JSON测试</h3>
	<a href="user/testJson1">测试json1-新页面</a><br>
	<a onclick="addUser()" style="cursor:pointer">测试json2-原生ajax</a><br>
	<a id="josn3" onclick="addUser2()" style="cursor:pointer">测试json3-jquery post方法</a><br>
	<span id="jsontext"></span>
	
	<h3>国际化</h3>
	<a href="i18/testI18n_1">国际化测试链接</a>
</body>
</html>