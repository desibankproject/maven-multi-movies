<!DOCTYPE html>
<html lang="en">
<head>
  <title>Registration Page</title>
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
  <h2>Customer Registration Page!</h2>
<img src="img/Icon 1-2.png"  style="height: 100px;">
  	<br/> 
  	<span style="color:red;font-size: 18px;">${message}</span>
  		<br/> 	<br/> 
  	<form action="cregister" method="post">
			Username :
			<input type="text" name="username" class="form-control" style="width: 50%"> 	
			<br/> 	
				Password :
			<input type="password" name="password" class="form-control" style="width: 50%"> 	
			<br/> 	
				Name :
			<input type="text" name="name" class="form-control" style="width: 50%"> 	
			<br/> 	
			
				Email :
			<input type="email" name="email" class="form-control" style="width: 50%"> 	
			<br/> 	
			
				Mobile :
			<input type="mobile" name="mobile" class="form-control" style="width: 50%"> 	
			<br/> 	
			<button type="submit" class="btn btn-primary">Register</button>
	</form>
	<hr/>
	
</div>

</body>
</html>
