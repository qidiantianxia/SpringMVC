<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="topage.html?pagename=oneUpload">单文件上传</a>
	</p>
	<p>
		<a href="topage.html?pagename=moreUpload">多文件上传</a>
	</p>
	<p>
		<a href="download.html?fileName=1.jpg">文件下载</a>
	</p>
	<p>
		<a href="topage.html?pagename=i18n">国际化</a>
	</p>
	<p>
		<a href="topage.html?pagename=login">验证码</a>
	</p>
</body>
</html>