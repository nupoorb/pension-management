<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!-- 
<html>
    <head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Pension Management</title>
    <style>
    body {
   
    font-family: sans-serif;
      background-image:linear-gradient(to top,black,white);
     background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    
}

.card {
    
    position: absolute;
    left: 70%;
    top:55%;
      
}

.needs-validation {
    width: 500px;
    height: 500px;
    padding: 40px;
    top:60%;
    align-content: center;
    padding-left:50px;
    background: lightgray;
    position: absolute;
    text-align: center;
    transition: 0.25s;
    margin-top: 100px
}

.needs-validation input[type="text"],
.needs-validation input[type="password"] {
    border: 0;
    background: white;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid black;
    padding: 20px 10px;
    width: 250px;
    outline: none;
    color: black;
    border-radius: 24px;
    transition: 0.25s;

}

.needs-validation h2 {
    color: black;
    text-transform: uppercase;
    font-weight: 500;
    padding-bottom: 50px;
    font-family: cursive;
}
.needs-validation p{
    color: black;
}
.needs-validation input[type="text"]:focus,
.needs-validation input[type="password"]:focus {
    width: 300px;
    border-color: black;
    
}

input[type="submit"] {
    border: 0;
    background:white;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid black;
    padding: 14px 40px;
    outline: none;
    color: black;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer;
  
}

 input[type="submit"]:hover {
    background:gray;
     
}




    </style>
    </head>
    <body>
    <div class="row">
        <div class="col-md-6">
            <div class="card">
       <form method="post" modelAttribute="login" action="/login"  class="needs-validation" novalidate>
                    <h2>Login Here</h2>
                      	<h4 class="error" > ${loginerror}</h4> 
                      <p class="text-muted"> Please enter your username and password!</p>
                      <div>
                    <input type="text" name="uid" class="form-control" placeholder="Username" required> 
                    <div class="invalid-feedback">Enter Valid Name</div>
                    </div>
                    <div>
           <input type="password" name="password" class="form-control" placeholder="Password" required> 
           <div class="invalid-feedback">Enter Valid password</div>
           </div>
                    <input type="submit" name="" value="Login" >
                    <div class="col-md-12">
                       
                        
                    </div>
                </form>
                   <!--    <script>
	(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script> 
            </div>
        </div>
    </div>

    </body>
</html> -->

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Untitled</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <style>
    .login-dark {
  height:607px;
  background:#475d62 ;
  background-size:cover;
  position:relative;
}

.login-dark form {
  max-width:320px;
  width:90%;
  background-color:#1e2833;
  padding:40px;
  border-radius:4px;
  transform:translate(-50%, -50%);
  position:absolute;
  top:50%;
  left:50%;
  color:#fff;
  box-shadow:3px 3px 4px rgba(0,0,0,0.2);
}

.login-dark .illustration {
  text-align:center;
  padding:15px 0 20px;
  font-size:100px;
  color:#2980ef;
}

.login-dark form .form-control {
  background:none;
  border:none;
  border-bottom:1px solid #434a52;
  border-radius:0;
  box-shadow:none;
  outline:none;
  color:inherit;
}

.login-dark form .btn-primary {
  background:#214a80;
  border:none;
  border-radius:4px;
  padding:11px;
  box-shadow:none;
  margin-top:26px;
  text-shadow:none;
  outline:none;
}

.login-dark form .btn-primary:hover, .login-dark form .btn-primary:active {
  background:#214a80;
  outline:none;
}

.login-dark form .forgot {
  display:block;
  text-align:center;
  font-size:12px;
  color:#6f7a85;
  opacity:0.9;
  text-decoration:none;
}

.login-dark form .forgot:hover, .login-dark form .forgot:active {
  opacity:1;
  text-decoration:none;
}

.login-dark form .btn-primary:active {
  transform:translateY(1px);
}

    
    </style>
</head>

<body>
    <div class="login-dark">
       <form method="post" modelAttribute="login" action="/login"  class="needs-validation" novalidate>
            <h2 class="sr-only">Login Form</h2>
            <h4 class="error" > ${loginerror}</h4> 
            <p class="text-muted"> Please enter your username and password!</p>
            <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
                                  <div class="form-group">
                    <input type="text" name="uid" class="form-control" placeholder="Username" required> 
                    <div class="invalid-feedback">Enter Valid Name</div>
                    </div>
            
    
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Log In</button></div>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>


