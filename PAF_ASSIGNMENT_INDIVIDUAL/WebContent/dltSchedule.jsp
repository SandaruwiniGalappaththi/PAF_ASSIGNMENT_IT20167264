<%@page import="com.Schedule"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="views/bootstrap.min.css">
<script src="components/jquery-3.6.0.min.js"></script>
<script src="components/schedule.js"></script>

  <link rel="stylesheet" href="C:\Users\Owner\git\assignment\PAF_ASSIGNMENT_INDIVIDUAL\WebContent\css\schedule.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  


<title>dltSchedule</title>
</head>
<body>
<style>
#back{
margin-left:10px;
}
</style>
<div class= "container">

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

 <div id="divItemsGrid">
<%
 	Schedule s = new Schedule();
 	out.print(s.readSchedule());
%>
</div>
</body>
</html>