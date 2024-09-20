<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Entity.UserData"%>
<%@page import="com.Entity.*" %>
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

<!-- <a href="addDetails.html" class="btn btn-info" style="margin:auto;">Add Details</a>  -->
<a href="addnote.jsp" class="btn btn-info" style="margin:auto;">Add Note</a>

<%
String check = (String) session.getAttribute("check");
ArrayList<UserData> al = (ArrayList<UserData>) session.getAttribute("notes");
if(check!=null)
{
%>
<h1 class="display-6 text-center">DashBoard</h1>
<h3 class="display-4">Welcome <%=check %></h3>
<a class="btn btn-danger" href="logout">logout</a>
<%@ include file="addnote.jsp" %>

<!-- read -->
<%
if(al !=null)
{
%>

<%
for(UserData note:al)
{
%>
<div class="container border w-50">
<p>
Note: <%=note.getNote() %>
</p>
<p class="pdate">
Add Date: <%=note.getAddDate() %>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Last Update: <%=note.getmDate() %>

</p>
<form action="deletenote" method="post">
<input type="hidden" name="note" value="<%=note.getNote()%>">
<input type="hidden" name="name" value="<%=check%>">
<button class="btn btn-danger btn-sm">Delete</button>
</form>
<%@include file="updatenote.jsp" %>
</div>
<br>
<%}
}
else
{
%>
<h1 class="text-center text-danger">please Add notes</h1>
<%} %>


<%} 
%>
else
{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>