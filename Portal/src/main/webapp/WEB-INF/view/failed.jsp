<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
    background-image: linear-gradient(to top,black,white);
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
	   width: 65%;
position: absolute;
	 position: absolute;
  top: 40%;
  left: 55%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  justify-content: center;
    padding-top:50px;
     border-radius: 5px;
  padding: 20px;
}
.btn-submit{
  width: 25%;
  background-color:black;
  color: white;
  top: 150%;
  left: 35%;
  position:absolute;
  border-radius: 4px;
  cursor: pointer;
  
}

.btn-submit:hover {
  background-color: white;
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
	         <h1>${message}</h1>
	
  <form method="post" action="/disburse">
      	<input   type="text"  placeholder="Pension Amount" name="aadhaar" value=${aadharno}  hidden >
	<input   type="text"  placeholder="Pension Amount" name="amount" value=${pensionAmount}  hidden>
          <input type="submit" class="btn btn-submit "value="Re-Calculate" >
         </form>
	</div>
        
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>


</body>
</html>