<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" >
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Pension Management</title>
	<style>

	</style>


</head>
 
 <body class="pen-body">
 
 
        <!--   Navbar starts here-->
  <nav  class="navbar navbar-dark bg-dark navbar-expand-sm justify-content-between">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/" id="pen-a">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout" id="pen-a"><span class="glyphicon glyphicon-log-in" id="pen-a"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--Navbar ends here    -->

<div class="pen-pension-form">
<h3 style="margin-left:5%">Enter Pensioner Details Here</h3>	
  	<form action="/submitinfo" method="post" modelAttribute="pensionerInput" class="needs-validation" novalidate>
  	<h3 class="error" style="color:red" > ${invaliddetails}</h3> 
	  <div>
		<label for="name" id="pen-label">Pensioner's Name</label>
		<input name="name" type="text" placeholder="Enter Pensioner's Name" class="form-control" required="required"/>
		<div class="invalid-feedback">
		Enter Valid Name
		</div> 

	  </div>
  <div>
	<label for="dateOfBirth" id="pen-label">Date Of Birth</label>
    <input name="dateOfBirth" type="date" placeholder="Enter your D.O.B" class="form-control" required>
 	<div class="invalid-feedback">
 	Enter Valid Date Of Birth
      </div> 

  </div>
  <div>
	<label for="pan" id="pen-label">PAN Number</label>
    <input name="pan" type="text"  placeholder="Enter your PanCard Number" class="form-control" pattern="[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}" title="Please enter valid PAN number. E.g. AAAAA9999A" required>
	<div class="invalid-feedback">
	Enter Valid PAN Number
      </div> 
  </div> 
 
 	<div>
		<label for="aadhar" id="pen-label">Aadhaar Number</label>
		<input  name="aadharNumber" type="text"  placeholder="Enter your Aadhaar Number" class="form-control" pattern="[1-9]{1}[0-9]{11}"  required>
	  <div class="invalid-feedback">
	  Enter Valid Aadhaar Number
		  </div>

	 </div>
    <br>
 Self Pension
  <input type="radio" name="pensionType"  value="self" required="required"  />
 &nbsp;&nbsp;&nbsp;&nbsp;
  Family Pension
 <input type="radio" name="pensionType"  value="family" required="required" /><br><br>
          
 <button type="submit" class="btn btn-submit" id="pen-btn-submit" >Submit</button>

</form>
  </div>

  
  
  </body>

</html>