<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>LginForm</title>
<style>
body{
background:#eeeeee;
font-family: Meiryo;
}
div{
	background: #ffffff;
	width: 300px;
	padding: 10px;
	text-align: center;
	border: 1px solid #cccccc;
	margin: 30px auto;
}
form{
background-color: #ffffff;
padding; 30px 50px;
}
form dl dt{
  width: 165px;
  padding:10px 0;
  float:left;
  clear:both;
}

form dl dd{
  padding:10px 0;
}
</style>
</head>
<body>
	<div>
	<h1>LOGIN FORM</h1>

	<form action="/LoginResult" method="post">
	<dl>
	    <dt>id</dt> <dd><input type="text" name = "id"></dd>
		<dt>password</dt><dd><input type="password" name = "password"></dd>
	</dl>
	<input type= "submit" value = "send">
	</form>

	<a href="/resister"> 新規登録はこちら</a>
	</div>

</body>
</html>