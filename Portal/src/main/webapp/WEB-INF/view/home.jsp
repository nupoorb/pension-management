<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
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

#first{
margin-left:200px;
background-color:gray;

}
#second{
margin-left:200px;
background-color:gray;
}
h1,h3,h4{
text-align:center;
color:black;

}
h5{
text-align:center;
color:black;
font-size:30px;

}
.card{
background-color:white;
position:absolute;
left:30%;
top:30%;
height:200px;

}
#one{
top:25%;
left:60%;
background-color:lightgray;

}
#two{
top:55%;
left:60%;
background-color:lightgray;

}
p{
text-align:center;}
.container{
   width: 50%;
   height:30%;
   left:5%;
   top:25%;
position: absolute;
	 float:left;
     padding-top:50px;
     border-radius: 5px;
  padding: 20px;
}
a.log{
color:white;
}
	</style>

</head>

<body>
  <nav  class="navbar navbar-dark bg-dark navbar-expand-sm justify-content-between">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Pension</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a class="log" href="/logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
 <h1 >Pension Management</h1>
 <div class="container">
 	        <img src="/backgrnd.png" width=100% height=200%/>
 </div>
	<div class="card" id="one" style="width: 35rem;">
  <div class="card-body">
    <h5 class="card-title">Disburse Amount</h5>
    <p class="card-text">To verify details entered and disburse pension amount of a pensioner.</p><br>
    <a href="/submitinfo" id="first" class="btn btn-primary">Click Here</a>
  </div>
</div>

	<div class="card" id="two" style="width: 35rem;">
  <div class="card-body">
    <h5 class="card-title">View Pensioner Detail</h5>
    <p class="card-text">To view details of pensioners whose pension amount is already disbursed. </p><br>
    <a href="/view" id="second" class="btn btn-primary">Click Here</a>
  </div>
</div>
	

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>

</body>

</html>
