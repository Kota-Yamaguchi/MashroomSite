<%@page import="mashroom.bean.Login"%>
<%@page import="mashroom.bean.MashOfAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<MashOfAccount> list = (List<MashOfAccount>) request.getAttribute("list");
Login account = (Login) session.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account</title>
</head>
<body>
<h1>your account page (<%= account.getName()%>)</h1>
<a href="/Login/Logout">ログアウトする</a><br>
<%
if (account.getId().equals("admin") || account.getName().equals("admin")) {
%>
<a href="/Login/admin/InsertMash">きのこ を新しく追加する</a>
<%} %>
<a href ="/Login/SelectMash">きのこ を検索する</a><br>
今まで検索したきのこ
<table>
<tr><th>名前</th></tr>
<%for (int i=0;i<list.size();i++){ %>
<tr><td><%= list.get(i).getMashname() %> </td></tr>
<% }%>
</table>


</body>
</html>