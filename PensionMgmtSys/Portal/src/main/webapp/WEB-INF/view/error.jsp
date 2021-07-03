<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" media="screen"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/verified.css" class="css">
<title>Pension Management</title>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" >
</head>

<body class="errbody">

	<!--   Navbar starts here-->
	<nav class="navbar navbar-inverse">
		<div class="err-container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Home</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout"><span
						class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>
	<!--Navbar ends here    -->
	<div class="err-pension-form">
		<form action="/login" method="get">
			<h1>Something went Wrong!Please Login again</h1>
			<input type="submit" class="btn btn-submit" id="err-btn-submit" value="Login">

		</form>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
		
	</script>


</body>
</html>