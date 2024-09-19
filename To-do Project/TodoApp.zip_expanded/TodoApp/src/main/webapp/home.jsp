<%@page import="com.Entity.UserData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.pdate{
font-size: 12px;
}
</style>
</head>
<body>

<%
String check=(String)session.getAttribute("check");
ArrayList<UserData> al=(ArrayList<UserData>) session.getAttribute("notes");
if(check!=null)
{
	

%>
<h1 class="display-6 text-center">DashBoard</h1>
<h3 class="display-4">welcome <%=check %></h3>
<a class="btn btn-danger" href="logout">logout</a>
<%@ include file="addnote.jsp" %>

<!-- read -->
<%
if(al!=null)
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
<%@ include file="updatenote.jsp" %>
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
else
{
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>