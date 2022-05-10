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
<script src="components/items.js"></script>

  <link rel="stylesheet" href="C:\Users\Owner\git\assignment\PAF_ASSIGNMENT_INDIVIDUAL\WebContent\css\schedule.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<title>scheduleForm</title>
</head>
<body>


<div class="container">
       <form action="schedule.jsp" class="needs-validation" novalidate id="formItem" name="formItem" method="post">
    <div class="form-group">
      <label for="location">Location</label>
      <input type="text" class="form-control" id="location" placeholder="Enter location" name="location" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="start">Start time:</label>
      <input type="time" class="form-control" id="start" placeholder="start time" name="start" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
     <div class="form-group">
      <label for="end">End time:</label>
      <input type="time" class="form-control" id="end" placeholder="end time" name="end" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="date">Date:</label>
      <input type="datetime" class="form-control" id="date" placeholder="date" name="date" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
   
    <input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn btn-primary">
<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

<%
 	Schedule s = new Schedule();
 	out.print(s.readSchedule());
%>
</body>
</html>