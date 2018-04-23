<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  hello  action
   <s:i18n name="message">
  	<s:text name="index.title"></s:text></s:i18n>
  	<s:if test="isUs == 0">
  		<s:i18n name="message">
  	<s:text name="index.title">
  		<s:param>张三</s:param>
  		<s:param>李四</s:param>
  		<s:param>也只能是曾经</s:param>
  	</s:text> 
  </s:i18n>
  	</s:if>
  	
  	<s:if test="isUs == 1">
  		<s:i18n name="message">
  	<s:text name="index.title">
  		<s:param>aa</s:param>
  		<s:param>cc</s:param>
  	</s:text> 
  </s:i18n>
  	</s:if>
 
</body>
</html>