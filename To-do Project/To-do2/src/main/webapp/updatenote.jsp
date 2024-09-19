<%@page import="java.util.ArrayList"%>
<%@page import="com.Entity.UserData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.popup{
display: none;
position: fixed;
z-index: 1;
left: 0px;
right: 0px;
top:100px;
width: 100%;
height: 100%;
}

.popup-content{
margin: 20px auto;
width: 50%;
background-color: #EAECEE ;
}

.close{
float: right;
font-size: 35px;
}
</style>

</head>
<body>


<%
String check2=(String)session.getAttribute("check");
ArrayList<UserData> al1=(ArrayList<UserData>) session.getAttribute("notes");
if(check2!=null)
{
	
	
	
%>

<button class="btn btn-info btn-sm" onclick="openform1()">Update</button>


<div class="popup" id="popupform1">
<div class="popup-content">

<h1 class="display-6 text-center">Update Note</h1>
<span class="close text-white btn btn-outline-danger" onclick="closeform1()">&times;</span>

<form action="updatenote" method="post">
<input type="hidden" name="uname" value="<%=check2%>">
<label class="form-label">Write Note</label>
<textarea rows="10" cols="30" name="note" class="form-control"></textarea>

<button class="btn btn-info">Submit</button>
</form>

</div>
</div>

<%} 
else
{
	response.sendRedirect("login.html");
}
%>





<script type="text/javascript">

function openform1()
{
	document.getElementById("popupform1").style.display="Block";
}
function closeform1()
{
	document.getElementById("popupform1").style.display="none";
}
</script>
</body>
</html>