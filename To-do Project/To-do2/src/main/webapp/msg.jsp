<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 String msg = (String)session.getAttribute("msg");
 if(msg!=null)
 {
	 
%>
<h1 Class="display-6 text-danger"><%=msg %></h1>
<%}

 else 
 {
	 session.removeAttribute("msg");
 }
 %>
</body>
</html>