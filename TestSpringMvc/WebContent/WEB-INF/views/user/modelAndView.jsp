<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>${requestScope.name }</h1>
 <h1>${name }</h1>
 
 <h1>${user.name }</h1>
 
 <c:if test="${ 1 == 1}">
 	1 == 1<br>
 </c:if>
 <c:if test="${user.name == '蔡彧'}">
 	user.name == '蔡彧'<br>
 </c:if>
  <c:if test="${name == '高锡'}">
 	name == '高锡'<br><br><br>
 </c:if>
 
<c:forEach var="u" items="${userList}" varStatus="idx">
	-----------  ${idx.index }  ---------<br>
	${u.name } <br>
</c:forEach>
</body>
</html>