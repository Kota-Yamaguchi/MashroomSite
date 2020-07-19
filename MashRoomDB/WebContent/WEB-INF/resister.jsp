<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<h1>会員の新規登録</h1>
<h2>ログインIDとパスワードを入力してください</h2>
<form action="<%=request.getContextPath() %>/resister" method="post">
名前:<input type= "text" name="name">
id:<input type="text" name = "id">
password:<input type="password" name = "password">
<input type="submit" value="send">
</form>
</body>
</html>