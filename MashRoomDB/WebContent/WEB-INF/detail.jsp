<%@page import="mashroom.bean.Mashroom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Mashroom mash = (Mashroom) request.getAttribute("mash");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きのこ詳細</title>
</head>
<body>
<h1><%=mash.getName() %></h1>
<h2>目：<%=mash.getOrder().getName() %></h2><br>
<h3>属：<%=mash.getFamily().getName() %></h3><br>
<img src="./image/benitengudake.jpg">

<table>
<tr><th>特徴</th><th>説明</th></tr>
<tr><td><%=mash.getAdnexed().getAdnexed() %></td><td><%=mash.getAdnexed().getRemarks() %></td></tr>
<tr><td><%=mash.getCaulescent().getCaulescent() %></td><td><%=mash.getCaulescent().getRemarks() %></td></tr>
<tr><td><%=mash.getCortex().getCortex() %></td><td><%=mash .getCortex().getRemarks()%></td></tr>
<tr><td><%=mash.getDensity().getDensity() %></td><td><%=mash.getDensity().getRemarks()%></td></tr>
<tr><td><%=mash.getCollar().getExist()%></td><td><%=mash.getCollar().getRemarks() %></td></tr>
<tr><td><%=mash.getVolva().getExist() %></td><td><%=mash.getVolva().getRemarks() %></td></tr>
<tr><td><%=mash.getGill().getGill() %></td><td><%=mash.getGill().getRemarks() %></td></tr>
</table>

</body>
</html>