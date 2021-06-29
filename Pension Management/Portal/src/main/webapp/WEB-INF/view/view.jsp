
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Pension Management</title>
    	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <style>
	body{
	  background:#475d62 ;
     background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
}
input{
  width: 15%;
  background-color: black;
  color: white;
left:40%;
position:absolute;

}

input:hover {
  background-color: white;
}
a.log{
color:white;}
.btn-submit{
display:inline-block;
  width:15%;
  background-color: black;
  color: white;
  padding: 5px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left:30px;
}


.btn-submit:hover {
  background-color: white;
}

</style>
</head>
<body >
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
<br><br><br><br>
     <div class = "tablelayout">
     <div class = "container" >
          
          <table class = "table table-striped" style="color:white">
            <thead>
                <tr>
                    <th>Aadhaar Number</th>
                    <th>Name</th>
                    <th>Date Of Birth</th>
                    <th>Pan Number</th>
                    <th>Pension Type</th>
                    <th>Pension Amount</th>
                    <th></th>
                </tr>
                
                
              </thead>
              <tbody>
                    <c:forEach items = "${listOfpension}" var ="pension">
                        <tr>
                        
                            <td>${pension.aadharNumber}</td>
                            <td>${pension.name}</td>
                            <td><fmt:formatDate value="${pension.dateOfBirth}" pattern="dd-MM-yyyy "/>
</td>
                            <td>${pension.pan}</td>
                            <td>${pension.pensionType}</td>
                            <td>${pension.pensionAmount}</td>
                           
                        </tr>
                                                
                
                    </c:forEach>
              </tbody>
          
          
          
          </table>
       <form method="get" action="/submitinfo">
       <br><br>
          <input type="submit" class="btn btn-submit "value="New Disbursement" >
    	
       </form> 
     </div>
    </div> 
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>