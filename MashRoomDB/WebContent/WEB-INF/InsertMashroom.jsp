<%@page import="mashroom.bean.Cortex"%>

<%@page import="mashroom.bean.Volva"%>
<%@page import="mashroom.bean.Gill"%>
<%@page import="mashroom.bean.Density"%>
<%@page import="mashroom.bean.Collar"%>
<%@page import="mashroom.bean.Caulescent"%>
<%@page import="mashroom.bean.Family"%>
<%@page import="mashroom.bean.Adnexed"%>
<%@page import="java.util.List"%>
<%@page import="mashroom.bean.Order" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Order> orlist = (List<Order>) application.getAttribute("orlist");
List<Family> famlist = (List<Family>) application.getAttribute("famlist");
List<Adnexed> adlist = (List<Adnexed>) application.getAttribute("adlist");
List<Caulescent> calist = (List<Caulescent>) application.getAttribute("calist");
List<Density> delist = (List<Density>) application.getAttribute("delist");
List<Gill> gilist = (List<Gill>) application.getAttribute("gilist");
List<Cortex> corlist = (List<Cortex>) application.getAttribute("corlist");
List<Collar> colist = (List<Collar>) application.getAttribute("colist");
List<Volva> volist = (List<Volva>) application.getAttribute("volist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きのこ</title>
</head>

<body>
<link rel ="stylesheet" href ="InsertStyle.css">
<jsp:include page="/WEB-INF/InsertHeaders.jsp" />


<section class="class">
<h1>きのこ を登録します。</h1>
<h2>きのこ の特徴を入力してください。</h2>
</section>
<form action="<%=request.getContextPath() %>/Login/admin/InsertMash" method="post">
名前:<input type="text" name="name"><br>
目:<select name="order">
<% for (int i=0;i<orlist.size();i++){%>
	<option value=<%=orlist.get(i).getId() %>><%=orlist.get(i).getName() %></option>
<%} %>
</select><br>

科:<select name="family">
<% for (int i=0;i<famlist.size();i++){ %>
	<option value=<%=famlist.get(i).getId() %>><%=famlist.get(i).getName() %></option>
<%} %>
</select><br>

<h3>ひだのつき方</h3>:<select name="adnexed">
<%for (int i=0;i<adlist.size();i++){ %>
<option value=<%=adlist.get(i).getAdnexedId() %>><%=adlist.get(i).getAdnexed() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<adlist.size();i++){ %>
	<tr><td><%=adlist.get(i).getAdnexed() %></td><td><%=adlist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>

<h3>柄の表現</h3>:<select name="caulescent">
<%for (int i=0;i<calist.size();i++){ %>
<option value=<%=calist.get(i).getCaulescentId() %>><%=calist.get(i).getCaulescent() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<calist.size();i++){ %>
<tr>	<td><%=calist.get(i).getCaulescent() %></td><td><%=calist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>

<h3>ひだの密度</h3>:<select name="density">
<%for (int i=0;i<delist.size();i++){ %>
<option value=<%=delist.get(i).getDensityId() %>><%=delist.get(i).getDensity() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<delist.size();i++){ %>
<tr>	<td><%=delist.get(i).getDensity() %></td><td><%=delist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>

<h3>傘下面:</h3><select name="gill">
<%for (int i=0;i<gilist.size();i++){ %>
<option value=<%=gilist.get(i).getGillId() %>><%=gilist.get(i).getGill() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<gilist.size();i++){ %>
<tr>	<td><%=gilist.get(i).getGill() %></td><td><%=gilist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>


<h3>傘の模様:</h3><select name="cortex">
<%for (int i=0;i< corlist.size();i++){ %>
<option value=<%=corlist.get(i).getCortexId() %>><%=corlist.get(i).getCortex() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<corlist.size();i++){ %>
<tr>	<td><%=corlist.get(i).getCortex() %></td><td><%=corlist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>

<h3>つばの有無</h3>>:<select name="collar">
<%for (int i=0;i<colist.size();i++){ %>
<option value=<%=colist.get(i).getCollarId() %>><%=colist.get(i).getExist() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<colist.size();i++){ %>
<tr>	<td><%=colist.get(i).getExist() %></td><td><%=colist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>

<h3>つぼの有無</h3><select name="volva">
<%for (int i=0;i<volist.size();i++){ %>
<option value=<%=volist.get(i).getVolvaId() %>><%=volist.get(i).getExist() %></option>
<%} %>
</select><br>
<table>
<tr><th>特徴</th><th>備考</th></tr>
<%for (int i=0;i<volist.size();i++){ %>
<tr>	<td><%=volist.get(i).getExist() %></td><td><%=volist.get(i).getRemarks() %></td></tr>
<%} %>
</table><br>


<input type="submit" value="send">
</form>


</body>
</html>