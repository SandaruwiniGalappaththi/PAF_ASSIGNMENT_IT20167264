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

<title>schedule</title>
</head>
 
<body>
<style>
span.b {
  display: inline-block;
  width: 314px;
  height: 200px;
  padding: 5px;
  border: 2px solid #F5FFFA;    
  background-color: #F5F5F5; 
  margin-right:40px;
}

li:hover {
  background-color:#FFA500;
}
h4{
margin-left:1px;
}
</style>
<br>

<div class="container">
<img src="C:\Users\Owner\git\assignment\PAF_ASSIGNMENT_INDIVIDUAL\WebContent\images\elec.jpg" alt="logo" width="50" height="35">
  <br><br>
  <!-- Nav pills -->
  <ul class="nav" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#home">Schedules</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#menu1">Search</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#menu2">Alerts</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <h3></h3>
      <p></p>
      
      
      <div>
       <div>
       <span class="b"><center><img src="C:\Users\Owner\git\assignment\PAF_ASSIGNMENT_INDIVIDUAL\WebContent\images\2.png" alt="logo" width="60" height="60"></center><br><center><h4>Add Power cut schedule</h4></center><br><center><a href="scheduleform.jsp"><font color="#FFA500">CLICK HERE</font></a></center></span>
     
       <span class="b"><center><img src="C:\Users\Owner\git\assignment\PAF_ASSIGNMENT_INDIVIDUAL\WebContent\images\3.png" alt="logo" width="56" height="56"></center><br><center><h4>Edit Power cut schedule</h4></center><br><center><a href="https://courseweb.sliit.lk"><font color="#FFA500">CLICK HERE</font></a></center></span>
       
        <span class="b"><center><img src="C:\Users\Owner\git\assignment\PAF_ASSIGNMENT_INDIVIDUAL\WebContent\images\4.png" alt="logo" width="56" height="56"></center><br><center><h4>Remove Power cut schedule</h4></center><br><center><a href="https://courseweb.sliit.lk"><font color="#FFA500">CLICK HERE</font></a></center></span>
       </div>
        <div>
       
       </div>
      </div>
      
      
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="container tab-pane fade"><br>
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
  </div>
</div>








</body>
</html>