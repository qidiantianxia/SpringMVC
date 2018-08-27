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
	<div style="margin: 0 auto; padding-top: 100px;" align="center">
		<form action="<%=path%>/doRegister.html" method="post">
			<p>
				${ERR_username} <span>username:</span> <input type="text"
					name="username" />
			</p>
			<p>
				${ERR_password} <span>password:</span> <input type="password"
					name="password" />
			</p>
			<p>
				${ERR_realname} <span>realname:</span> <input type="text"
					name="realname" />
			</p>
			<p>
				${ERR_age} <span>age:</span> <input type="text" name="age" />
			</p>
			<p>
				${ERR_email} <span>email:</span> <input type="text" name="email" />
			</p>
			<p>
				<input type="submit" value="submit" />
			</p>

		</form>
	</div>
</body>
</html>