<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<style>
	

	
	</style>


</head>

<body class="ver-body">

        <!--   Navbar starts here-->
  <nav  class="navbar navbar-dark bg-dark navbar-expand-sm justify-content-between">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/" id="ver-a">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout" id="ver-a"><span class="glyphicon glyphicon-log-in" id="ver-a"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--Navbar ends here    -->

<!--    Pensioner Details Form Starts Here-->

    <div class="ver-pension-form">
  <h3 style="margin-left:-10%">Details Verified!</h3>
  <form action="/disburse" method="post" >
  
   <span class="ver-span"> <label class="ver-label">Pensioner's Name</label><input class="ver-input" type="text"  value=${name}  readonly></span>
  

  <span class="ver-span">  <label class="ver-label">Date Of Birth</label> <input class="ver-input"type="text"  value=<fmt:formatDate value="${dob}" pattern="dd-MM-yyyy "/>  readonly></span>

  <span class="ver-span">  <label class="ver-label">Pan Card Number</label><input class="ver-input" type="text"   value=${pan} readonly></span>

  <span class="ver-span">  <label class="ver-label">Aadhaar Number</label><input  class="ver-input" type="text"  value=${aadharno} length="12" readonly ><br></span>
   
    <span class="ver-span"><label class="ver-label">Pension Type</label><input class="ver-input"  type="text" placeholder="Pension Type"  value=${pensionType} readonly></span>

	 <span class="ver-span"><label class="ver-label">Amount</label>   <input class="ver-input"  type="text"  placeholder="Pension Amount" value=${pensionAmount}  readonly></span>

	<input   type="text" class="ver-input" placeholder="Pension Amount" name="aadhaar" value=${aadharno}  hidden >
	<input   type="text" class="ver-input" placeholder="Pension Amount" name="amount" value=${pensionAmount}  hidden>

<input type="submit" id="ver-btn-submit" class="btn btn-submit" value="Proceed" />

   
   </form>
  </div>

</body>

</html>











</html>