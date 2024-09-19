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
String check1=(String)session.getAttribute("check");
if(check1!=null)
{
	
%>
<button class="btn btn-info" onclick="openform()">Add</button>

<div class="popup" id="popupform">
<div class="popup-content">

<h1 class="display-6 text-center" >Add Note</h1>
<span class="close text-white btn btn-outline-danger" onclick="closeform()">&times;</span>

<form action="addnote" method="post">
<input type="hidden" name="uname" value="<%=check1%>">
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

function openform()
{
	document.getElementById("popupform").style.display="Block";
}
function closeform()
{
	document.getElementById("popupform").style.display="none";
}
</script>
</body>
</html>