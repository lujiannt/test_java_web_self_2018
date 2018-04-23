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
	<a href="curd/listUser">用户列表</a><br>
	
	
</body>
</html>