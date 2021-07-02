<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Untitled</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" >
    <style>
 
    
    </style>
</head>

<body style="background-color:#475d62">
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


