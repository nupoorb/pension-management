<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
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

<body class="eval-body">

        <!--   Navbar starts here-->
  <nav  class="navbar navbar-dark bg-dark navbar-expand-sm justify-content-between">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/" id="eval-a">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout" id="eval-a"><span class="glyphicon glyphicon-log-in" id="eval-a"></span> LogOut</a></li>
    </ul>
  </div>
</nav>

      <div class="eval-pension-form">
    <form action="/evaluate" method="post" >


       		<label >Aadhaar Number </label>
            <input  value='${aadhaar}'  class="eval-input"  required="required" readonly="readonly"/><br/>
 
            <label >Pension Amount</label>
            <input  value='${amount}' class="eval-input"  required="required" readonly><br/>
            
             <label >Bank Charge</label>
<!--           <input type="radio" name="bankcharge" value="550"><label for="bankcharge" style="color:white">Private</label> 
		  <input type="radio"  name="bankcharge" value="500"><label for="bankcharge" style="color:white">Public</label><br>
          -->
			<div class="form-check">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="bankcharge" value="550">Private
				</label>
			</div><div class="form-check">
			
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="bankcharge" value="500">Public
				</label>
			</div>

			<input name="aadhaar" value='${aadhaar}'  id="eval-input"  required="required" hidden="hidden"/><br/>
 
           
            <input name="amount" value='${amount}' id="eval-input" required="required" hidden="hidden" /><br/>
       
       
        	<input style="width:200px;margin-left:125px;" id="eval-btn-submit"type="submit" class="btn btn-submit "value="Proceed To Disbursement" >
			
       
  	</form>
		</div>

</body>
</html>