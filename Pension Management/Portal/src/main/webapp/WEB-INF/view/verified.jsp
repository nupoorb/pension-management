<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

a.log{
color:white;
}
/* Pensioner Details Form Styling*/

.pension-form{
	   width: 40%;
	 
position: absolute;

  top: 63%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  justify-content: center;
    
     border-radius: 5px;
background:black;
color:white;
  padding-left: 20px;
}




input, select {
  width: 90%;
  padding: 6px 16px;
  margin: 8px 0;
  display: inline-block;
  box-sizing: border-box;
    background:none;
  border:none;
  border-bottom:1px solid #434a52;
  border-radius:0;
  box-shadow:none;
  outline:none;
  color:inherit;
}

  .btn-submit{
  width: 35%;
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  margin-top: 30px;
  margin-left: 170px;

  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-submit:hover {
  background-color: white;
}


label {
    /* Other styling... */
   
    float:left;
}

span { 
   			 margin: 0px;
            display: block; 
            overflow: hidden; 
            padding: 0px 0px 0px 0px; 
        } 


.self{
    padding-right: 18px;
}
	h2{
padding-bottom:20px;

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
      <a class="navbar-brand" href="/">Pension</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a class="log" href="/logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--Navbar ends here    -->

<!--    Pensioner Details Form Starts Here-->

    <div class="pension-form">
  <h3 style="margin-left:110px">Details Verified!</h3>
  <form action="/disburse" method="post" >
  
   <span> <label>Pensioner's Name</label><input type="text"  value=${name}  readonly></span>
  

  <span>  <label>Date Of Birth</label> <input type="text"  value=<fmt:formatDate value="${dob}" pattern="dd-MM-yyyy "/>  readonly></span>

  <span>  <label>Pan Card Number</label><input  type="text"   value=${pan} readonly></span>

  <span>  <label>Aadhaar Number</label><input   type="text"  value=${aadharno} length="12" readonly ><br></span>
   
    <span><label>Pension Type</label><input   type="text" placeholder="Pension Type"  value=${pensionType} readonly></span>

	 <span><label>Amount</label>   <input   type="text"  placeholder="Pension Amount" value=${pensionAmount}  readonly></span>

	<input   type="text"  placeholder="Pension Amount" name="aadhaar" value=${aadharno}  hidden >
	<input   type="text"  placeholder="Pension Amount" name="amount" value=${pensionAmount}  hidden>

<input type="submit" class="btn btn-submit" value="Proceed" />

   <!-- <a  href="/disburse" class="btn btn-submit">Link for disbursement</a> -->
   
   <!-- <a href="/disburse" class="btn btn-submit"  onClick="document.getElementById('form1').submit();">Link for disbursement</a> -->
   
   </form>
  </div>
      
                
<!--    Pensioner Details Form Ends Here-->
    



</body>

</html>











</html>