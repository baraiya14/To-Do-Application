<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Entity.Info"%>
<%@page import="com.Entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="SerialNumberS.js"></script>
<title>Home Page</title>
</head>
<body>
<div  class="text-center" >
<h1 class="display-6" >To Do Application</h1>

<a href="addDetails.html" class="btn btn-info" style="margin:auto;">Add Details</a>

<%
String check = (String) session.getAttribute("check");
ArrayList<Info> all = (ArrayList<Info>) session.getAttribute("all");

ArrayList<User> al = (ArrayList<User>) session.getAttribute("al");


if(check!=null)
{
%>
<table class="table table-bordered w-50 text-center" style="margin-left: auto; margin-right: auto; margin-top: 10px;">
<thead>
<tr>
<th>Sr.no</th>
<th>Id</th>
<th>Name</th>
<th>Fees</th>
<th>Edit Info</th>
<th>Delete Info</th>
</tr>
</thead>
<tbody>

<%
int serialNumber = 1;
for (Info i : all) {
%>
<tr>
<td><%= serialNumber++ %></td>
<td><%=i.getId() %></td>
<td><%=i.getName()%></td>
<td><%=i.getFees()%></td>
<td>
<button style="border: none; outline: none; margin: 0px; padding: 0px;">
<a href="editDetails.html"  class="btn btn-info">Edit</a>
</button>
</td>

<td>
<form action="delInfo">
<input type="hidden" name="id" value="<%=i.getId()%>">
<button class="btn btn-info">delete</button>
</form>
</td>
</tr>
<% } %>
</tbody>
</table>
</div>
<%} 
else
{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>