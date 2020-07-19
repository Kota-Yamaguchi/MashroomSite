
<%@page import="mashroom.bean.Order"%>
<%@page import="java.util.List"%>
<%@page import="mashroom.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%OrderDao od = new OrderDao();
List<Order> orlist = od.findAll();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/InsertHeaders.jsp" />


<h1>きのこ の「目」を登録できます</h1>
<form action="<%=request.getContextPath() %>/InsertOrder" method="post">
<input type="text" name="id"><br>
<input type="text" name="name"><br>
<input type= "submit" value="送信">
</form>


<h3>登録されている「目」一覧</h3>
<table>
<tr><th>ID</th><th>目名</th></tr>
<%for (int i=0;i<orlist.size();i++){ %>
<tr><td> <%= orlist.get(i).getId()%></td><td><%= orlist.get(i).getName()%> </td></tr>
<% }%>
</table>
</body>
</html>