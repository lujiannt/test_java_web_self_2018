<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String BasePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<title>Insert title here</title>
</head>
<body>
 
 <form name="Form1" action="<%=BasePath %>user/upload1" method="post"  enctype="multipart/form-data">
<h1>采用springMvc multipart提供的file.transfer方法上传文件</h1>
<input type="file" name="file"><br>
<input type="submit" value="上传文件1"/>
 使用时间${useTime}
</form>
<img src="<%=BasePath %>${fileUrl}">  


 <form name="Form2" action="<%=BasePath %>user/upload2" method="post" enctype="multipart/form-data">
<h1>采用springMvc commonsMultipart提供的file.transfer方法上传文件</h1>
<input type="file" name="file"><br>
<input type="submit" value="上传文件2"/>
 使用时间${useTime1}
</form>
<img src="<%=BasePath %>${fileUrl1}">  



 <form name="Form3" action="<%=BasePath %>user/upload3" method="post"  enctype="multipart/form-data">
<h1>采用流的方法上传文件</h1>
<input type="file" name="file"><br>
<input type="submit" value="上传文件3"/>
使用时间${useTime2}
</form>
<img src="<%=BasePath %>${fileUrl2}">  

 <form name="Form4" action="<%=BasePath %>user/upload4" method="post"  enctype="multipart/form-data">
<h1>采用流的方法（加入缓冲字节数组）上传文件</h1>
<input type="file" name="file"><br>
<input type="submit" value="上传文件4"/>
使用时间${useTime3},文件字节数${length }
</form>
<img src="<%=BasePath %>${fileUrl3}">  

 <form name="Form5" action="<%=BasePath %>user/upload5" method="post"  enctype="multipart/form-data">
<h1>采用流的方法（bufferedInputStream来读取）上传文件</h1>
<input type="file" name="file"><br>
<input type="submit" value="上传文件5"/>
使用时间${useTime4}
</form>
<img src="<%=BasePath %>${fileUrl4}">  

 <form name="Form6" action="<%=BasePath %>user/upload6" method="post"  enctype="multipart/form-data">
<h1>采用apache自带的方法上传文件</h1>
<input type="file" name="file"><br>
<input type="submit" value="上传文件6"/>
使用时间${useTime5}
</form>
<img src="<%=BasePath %>${fileUrl5}"> 


<form name="Form6" action="<%=BasePath %>user/upload7" method="post"  enctype="multipart/form-data">
<h1>采用spring自带的方法上传文件,可进行多文件上传</h1>
<input type="file" name="file"><br>
<input type="file" name="file1"><br>
<input type="submit" value="上传文件6"/>
使用时间${useTime6}
</form>
<img src="<%=BasePath %>${fileUrl6}"> 
<img src="<%=BasePath %>${fileUrl7}"> 
<a href="<%=BasePath %>${fileUrl6}">点击下载（超链接方式）</a>
<a href="<%=BasePath %>user/download?fileName=AppUI.zip">点击下载（java通用方式）</a>
<a href="<%=BasePath %>user/download1?fileName=ui好点的.zip">点击下载（responseEntity方式）</a>
</body>
</html>