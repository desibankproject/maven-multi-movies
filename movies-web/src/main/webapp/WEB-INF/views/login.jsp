<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <h2>Login  User Page!</h2>
<img src="img/login-icon.png"  style="height: 100px;">
  	<br/> 
  	<span style="color:red;font-size: 18px;">${message}${param.message}</span>
  		<br/> 	<br/> 
  	<form action="oauth" method="post">
			Username :
			<input type="text" name="username" class="form-control" style="width: 50%"> 	
			<br/> 	
			<br/> 	
				Password :
			<input type="password" name="password" class="form-control" style="width: 50%"> 	
			<br/> 	
			<button type="submit" class="btn btn-primary">Login</button>
				 <a href="cregister">
				<button type="button" class="btn btn-primary">Register</button>
			</a>
	</form>
	<hr/>
	
</div>

</body>
</html>
