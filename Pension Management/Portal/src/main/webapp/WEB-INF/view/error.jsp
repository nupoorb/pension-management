<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/verified.css" class="css">
	<title>Pension Management</title>

	<!--  -->
<style>
    body{
	  background:#475d62 ;
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    
}



.container-fluid{
    padding: 0px 15px;
}


.fa-hand-holding-usd , .fa-info-circle, .fa-user-plus{
/*    color: white;*/
    padding-right: 5px;
}


/* Pensioner Details Form Styling*/

.pension-form{
	   width: 55%;
position: absolute;
	 position: absolute;
  top: 40%;
  left: 60%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  justify-content: center;
    padding-top:50px;
     border-radius: 5px;
  padding: 20px;
  color:white;
  background-color: black;
}
.btn-submit{
  width: 25%;
  background-color: black;
  color: white;
  top: 150%;
  left: 25%;
  position:absolute;
  border-radius: 4px;
  cursor: pointer;
  
}

.btn-submit:hover {
  background-color: white;
}

 </style>

</head>

<body>

        <!--   Navbar starts here-->
     <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Pension</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
	<!--Navbar ends here    -->
	<div class="pension-form">
  <form action="/login" method="get">
         <h1>Something went Wrong!Please Login again</h1>
          <input type="submit" class="btn btn-submit" value="Login" >
    	
       </form> 
       </div>
      
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>


</body>
</html>