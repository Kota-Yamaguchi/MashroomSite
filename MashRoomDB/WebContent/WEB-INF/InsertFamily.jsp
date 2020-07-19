<%@page import="mashroom.dao.FamilyDao"%>
<%@page import="java.util.List"%>
<%@page import="mashroom.bean.Family" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
FamilyDao fdao = new FamilyDao();
List<Family> f = fdao.findAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科を新しく追加</title>
</head>
<body>
<jsp:include page="/WEB-INF/InsertHeaders.jsp" />



<h1>きのこ の「科」を新しく追加できます。</h1>
<form action="<%=request.getContextPath() %>/Login/admin/InsertFamily" method="post">
<input type="text" name="id"><br>
<input type="text" name="name"><br>
<input type= "submit" value="送信">
</form>

<form action="<%=request.getContextPath() %>/Login/admin/DeleteConfirm" method="post">
<h3>登録されている「科」一覧</h3>
<table>
<tr><th>ID</th><th>科名</th><th>削除</th>></tr>
<%for (int i=0;i<f.size();i++){ %>
<tr><td> <%= f.get(i).getId()%></td>
<td><%= f.get(i).getName()%> </td>
<td><button type="submit" name="delete" value=<%=f.get(i).getId()%>>削除</button></td></tr>
<% }%>
</table>
</form>

</body>
</html>