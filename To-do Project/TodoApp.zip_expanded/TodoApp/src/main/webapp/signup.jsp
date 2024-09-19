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

<h1 class="display-6 text-center">SignUp</h1>
<a class="btn btn-danger" href="login.jsp">Login</a>

<!-- msg  -->
<%@ include file="msg.jsp" %>
<div class="container w-75">
<form action="signup">

<label class="form-label">Enter UserName</label>
<input type="text" name="uname" class="form-control">

<label class="form-label">Enter Password</label>
<input type="password" name="upass" class="form-control">

<label class="form-label">Enter Email</label>
<input type="email" name="uemail" class="form-control">

<label class="form-label">Enter DOB</label>
<input type="date" name="udob" class="form-control">

<button class="btn btn-success mt-4">SignUp</button>
</form>
</div>

</body>
</html>