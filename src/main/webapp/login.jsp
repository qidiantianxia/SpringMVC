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
	<script>
		var i = 1;
		function changeCode() {
			document.getElementById("id").src = "vcode.html?v=" + (i++);
		}
	</script>
	<form action="doLogin.html" method="post">
		<p>
			<input type="text" name="vcode">
		</p>

		<p>
			<input type="image" id="vcode" src="vcode.html"
				onclick="changeCode()">
		</p>
		<p>
			<input type="submit" value="submit" />
		</p>
	</form>
	<font color="red">${error}</font>
</body>
</html>