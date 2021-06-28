
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
                    <div class="invalid-feedback">Enter Valid Name</div></div>
                    <div>
           <input type="password" name="password"  class="form-control" placeholder="Password" required> 
           <div class="invalid-feedback">Enter Valid password</div>
           </div>
                    <input type="submit" name="" value="Login" >
                    <div class="col-md-12">
                       
                        
                    </div>
                </form>
                      <script>
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
</html>