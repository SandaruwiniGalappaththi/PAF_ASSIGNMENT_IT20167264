<%@page import="com.Alert"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="views/bootstrap.min.css">
<script src="components/jquery-3.6.0.min.js"></script>
<script src="components/searchAcc.js"></script>
<title>SetAlert</title>
</head>
<body>
<style>
#back{
margin-left:10px;
}
</style>
<div class="container">
<form id="setAlert" name="setAlert" method="post" action="setAlert.jsp">
Account Number
<input id="acc" name="acc" type="text"
 class="form-control form-control-sm">
<br>
Email
<input id="mail" name="mail" type="email"
 class="form-control form-control-sm"><br><br>
<input id="btnSave" name="btnSave" type="submit" value="Save"
 class="btn btn-primary">
 <a href="schedule.jsp"><buttton id="back" type="button"class="btn btn-secondary">Back</buttton>
</form>



<%
if (request.getParameter("acc") != null)
{
Alert alert = new Alert();
out.print(alert.checkVerification(request.getParameter("acc"),request.getParameter("mail")));
}
%>
</body>
</html>