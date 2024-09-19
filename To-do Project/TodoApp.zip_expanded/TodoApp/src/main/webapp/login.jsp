<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 class="display-6 text-center">Login</h1>
<!-- msg  -->
<%@ include file="msg.jsp" %>
<div class="container w-75">

<form action="login">

<label class="form-label">Enter UserName</label>
<input type="text" name="uname" class="form-control">

<label class="form-label">Enter Password</label>
<input type="password" name="upass" class="form-control">



<button class="btn btn-success mt-4">Login</button>
</form>
</div>

</body>
</html>