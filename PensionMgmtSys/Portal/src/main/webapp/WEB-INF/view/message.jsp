<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

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
	<!--  -->
<style>

 </style>

</head>

<body class="msg-body">

        <!--   Navbar starts here-->
   <nav  class="navbar navbar-dark bg-dark navbar-expand-sm justify-content-between">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/" id="a1">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout" id="a1"><span class="glyphicon glyphicon-log-in" id="a1"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
	<!--Navbar ends here    -->
	<div class="msg-pension-form" style="margin-left:-80px">
  <form action="view" style="margin-left:60px">
         <h1>${message}</h1>
          <input type="submit" class="btn btn-submit " id="msg-btn-submit"value="View Details" style="margin-left:80px" >
    	
       </form> 
       </div>
      
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>


</body>
</html>