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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Pension Management</title>
	<style>
	body{
    background-image:linear-gradient(to top,black,white);
     background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    
    
	}



/* Pensioner Details Form Styling*/

.pension-form{
	   width: 40%;
position: absolute;

  top: 50%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  justify-content: center;
    padding-top:50px;
     border-radius: 5px;
background:lightgray;
  padding: 20px;
}



.btn-submit{
display:inline-block;
  width: 25%;
  background-color: black;
  color: white;
  padding: 5px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left:200px;
}


.btn-submit:hover {
  background-color: white;
}

label {
    /* Other styling... */
   
    float:left;
}


	
.error{
		
	color:black;
	text-align:center;		
	font-size: 25px;
}
h2{
padding-bottom:20px;
padding-top:40px;
font-family:cursive;
margin:auto;
text-align:center;
}
a{
color:white;
}

	</style>


</head>
 
 <body>
 
 
        <!--   Navbar starts here-->
  <nav  class="navbar navbar-dark bg-dark navbar-expand-sm justify-content-between">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Pension</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--Navbar ends here    -->

<div class="pension-form">
<h2>Enter Pensioner Details Here!</h2>
	
  	<form action="/submitinfo" method="post" modelAttribute="pensionerInput" class="needs-validation" novalidate>
  	<h2 class="error" > ${invaliddetails}</h2> 
	  <div>
		<label for="name">Pensioner's Name</label>
		<input name="name" type="text" placeholder="Enter Pensioner's Name" class="form-control" required="required"/>
		<div class="invalid-feedback">
		Enter Valid Name
		  </div> 

	  </div>
  <div>
	<label for="dateOfBirth">Date Of Birth</label>
    <input name="dateOfBirth" type="date" placeholder="Enter your D.O.B" class="form-control" required>
 	<div class="invalid-feedback">
 	Enter Valid Date Of Birth
      </div> 

  </div>
  <div>
	<label for="pan">PAN Number</label>
    <input name="pan" type="text"  placeholder="Enter your PanCard Number" class="form-control" pattern="[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}" title="Please enter valid PAN number. E.g. AAAAA9999A" required>
	<div class="invalid-feedback">
	Enter Valid PAN Number
      </div> 
  </div> 
 
 	<div>
		<label for="aadhar">Aadhaar Number</label>
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
          
 <button type="submit" class="btn btn-submit" >Submit</button>

</form>
  </div>
  
  

  
  <script>
	(function() {
'use strict';
window.addEventListener('load', function() {
  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.getElementsByClassName('needs-validation');
  // Loop over them and prevent submission
  var validation = Array.prototype.filter.call(forms, function(form) {
    form.addEventListener('submit', function(event) {
      if (form.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
      }
      form.classList.add('was-validated');
    }, false);
  });
}, false);
})();
</script>
  
  
  </body>

</html>