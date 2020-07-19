<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>LginForm</title>
<link rel="stylesheet" type="text/css" href ="/<%=request.getContextPath() %>/stylesheet/top.css">
</head>
<body>
	<div>
	<h1>LOGIN FORM</h1>

	<form action="<%=request.getContextPath() %>/LoginResult" method="post">
	<dl>
	    <dt>id</dt> <dd><input type="text" name = "id"></dd>
		<dt>password</dt><dd><input type="password" name = "password"></dd>
	</dl>
	<input type= "submit" value = "send">
	</form>

	<a href="<%=request.getContextPath() %>/resister"> 新規登録はこちら</a>
	</div>

</body>
</html>