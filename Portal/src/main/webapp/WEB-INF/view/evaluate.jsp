<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
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
      background-image:linear-gradient(to top,black,white);
     background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
}

a.log{
color:white;
}

.container-fluid{
    padding: 0px 15px;
    margin:auto;
}


.fa-hand-holding-usd , .fa-info-circle, .fa-user-plus{
/*    color: white;*/
    padding-right: 5px;
}


/* Pensioner Details Form Styling*/


.pension-form{
	   width: 40%;
position: absolute;
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


input, select {
  width: 100%;
  padding: 6px 16px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

  .btn-submit{
  width: 35%;
  heigth:30%;
  background-color: black;
  color: white;
  margin: 8px 0;
  margin-left: 170px;

  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-submit:hover {
  background-color: white;
}
	h2{
padding-bottom:20px;
padding-top:40px;
font-family:cursive;
margin:auto;
text-align:center;
}
	
	
	</style>
</head>

<body>

        <!--   Navbar starts here-->
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
<!--Navbar ends here    -->
    
 
    
    
       
<!--    Disbursement Form Starts Here-->

   <!--   <div class="pension-form">
    <form:form action="/evaluate" method="post" modelAttribute="processPensionInput">


       		<form:label path="aadharNumber">Aadhaar Number </form:label>
            <form:input path="aadharNumber" value='${aadhaar}'   length="12" required="required"/><br/>
 
            <form:label path="pensionAmount">Pension Amount</form:label>
            <form:input path="pensionAmount" value='${amount}'   required="required"/><br/>
            
             <form:label path="bankCharge">Bank Charge</form:label>
            <form:input path="bankCharge"     required="required"/><br/>
       
       
        	<input type="submit" class="btn btn-submit "value="Proceed To Disbursement" >
			
       
  	</form:form>
		</div>
  
  -->
      <div class="pension-form">
    <form action="/evaluate" method="post" >


       		<label >Aadhaar Number </label>
            <input  value='${aadhaar}'    required="required" readonly="readonly"/><br/>
 
            <label >Pension Amount</label>
            <input  value='${amount}'   required="required" readonly><br/>
            
             <label >Bank Charge</label>
            <input name="bankcharge" required="required" type="number" placeholder="Enter BankCharge" min="0"/><br/>
       
      		<input name="aadhaar" value='${aadhaar}'    required="required" hidden="hidden"/><br/>
 
           
            <input name="amount" value='${amount}'  required="required" hidden="hidden" /><br/>
       
       
        	<input type="submit" class="btn btn-submit "value="Proceed To Disbursement" >
			
       
  	</form>
		</div>
  
  
                
<!--    Disbursement Form Ends Here-->
    
    
</body>
</html>