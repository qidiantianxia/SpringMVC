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

	<form action="oneUpload.html" method="post"
		enctype="multipart/form-data">
		<p>
			<span>文件：</span> <input type="file" name="imageFile" />
		</p>
		<p>
			<input type="submit" value="submit" />
		</p>
	</form>
</body>
</html>