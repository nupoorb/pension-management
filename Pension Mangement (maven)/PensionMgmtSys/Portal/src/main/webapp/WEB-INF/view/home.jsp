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
  background:#475d62 ;
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
}

#first{
margin-left:32%;
margin-top:25%;
width:250px;
}
#second{
margin-left:0%;
margin-top:25%;
width:250px;

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
top:50%;
height:200px;

}
#one{
top:65%;
left:5%;
background-color:lightgray;
}
#two{
top:65%;
left:50%;
background-color:lightgray;

}
p{
text-align:center;}
.container{
   width: 40%;
   height:25%;
   left:30%;
   top:20%;
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
      <a class="navbar-brand" href="#">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a class="log" href="/logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
 <h1 style="color:white">Pension Management</h1>
 <div class="container">
 	        <img src="/pension-bkg.jpg" width=100% height=200%/>
 </div>
 
    <a href="/submitinfo" id="first" class="btn btn-success">Disburse Amount</a>


    <a href="/view" id="second" class="btn btn-info">View Pensioner Detail</a>

	

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>

</body>

</html>
