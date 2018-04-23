<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib   prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload.action" method="post" enctype="multipart/form-data">
		<input type="file" name="bookPic"><br>
		<input type="submit" value="提交">
	</form>
	
	<a href="download1.action">下载1</a>
	<a href="download2.action">下载2</a>
	错误:<s:actionerror/>
</body>
</html>