<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>本当に削除しますか？？</h1>
<form action="<%=request.getContextPath() %>/Login/admin/DeleteFamily" method="post">
<button type="submit" name="which" value=0>はい</button>
<button type="submit" name="which" value=1>いいえ</button>
</form>

</body>
</html>