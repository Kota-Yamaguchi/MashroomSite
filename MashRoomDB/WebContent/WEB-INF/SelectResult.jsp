<%@page import="mashroom.bean.Mashroom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List<Mashroom> mashlist = (List<Mashroom>) request.getAttribute("mashlist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/Login/detail" method="post">
<table>

<% for(int i =0 ; i<mashlist.size();i++){%>
<tr><th>名前</th><th>詳細へ</th></tr>
<tr><td><%=mashlist.get(i).getName() %></td>
<td><button type="submit" name="detail" value=<%=mashlist.get(i).getName() %> >詳細へ</button></td></tr>
<%} %>
<a href = "<%=request.getContextPath() %>/Login/SelectMash">検索formに戻る</a>
</table>
</form>
</body>
</html>