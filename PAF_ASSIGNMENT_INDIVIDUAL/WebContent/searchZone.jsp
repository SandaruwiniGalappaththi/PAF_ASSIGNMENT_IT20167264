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
<title>earchByZone</title>
</head>
<body>
<style>
#back{
margin-left:10px;
}
</style>
<div class= "container">
<form id="searchZone" name="searchZone" method="post" action="searchZone.jsp">
Zone
<input id="zone" name="zone" type="text"
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="submit" value="Save"
 class="btn btn-primary">
 <a href="schedule.jsp"><buttton id="back" type="button"class="btn btn-secondary">Back</buttton>
</form>



 
<%
if (request.getParameter("zone") != null)
{
TimeTable tt = new TimeTable();
out.print(tt.readByZone(request.getParameter("zone")));
}
%>
</body>
</html>