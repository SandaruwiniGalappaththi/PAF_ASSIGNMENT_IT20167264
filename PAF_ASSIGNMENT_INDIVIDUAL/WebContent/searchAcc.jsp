<%@page import="com.TimeTable"%>
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
<title>earchByAcc</title>
</head>
<body>
<style>
#back{
margin-left:10px;
}
</style>
<div class= "container">
<form id="searchAccc" name="searchAccc" method="post" action="searchAcc.jsp">
Account Number
<input id="acc" name="acc" type="text"
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="submit" value="Save"
 class="btn btn-primary">
 <a href="schedule.jsp"><buttton id="back" type="button"class="btn btn-secondary">Back</buttton>
</form>



 
<%
if (request.getParameter("acc") != null)
{
TimeTable tt = new TimeTable();
out.print(tt.readByAcc(request.getParameter("acc")));
}
%>
</body>
</html>