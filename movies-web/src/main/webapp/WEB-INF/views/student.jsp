<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
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
  <h2>Student Registration Page</h2>
<img src="img/student.jpg" class="img-thumbnail" style="height: 200px;">
  	<br/> 	<br/> 	<br/> 
  	<form action="studentRegistration" method="post">
  		<table class="table table-bordered">
  		 <tr>
  		  <td>
			Name :
			</td>
			<td>
			<input type="text" name="name" class="form-control" style="display: inline;margin-right: 30px;"> 	
			</td>
			</tr>
			<tr>
			  <td>
			Gender :
			</td>
			  <td>
			<select  name="gender" class="form-control" style="display: inline;margin-right: 30px;"> 	
				<option>Male</option>
				<option>Female</option>
				<option>Others</option>
			</select>
			</td>
			</tr>
				<tr>
			  <td>
			School :
			</td>
			  <td>
			<input type="text" name="school" class="form-control" style="display: inline;margin-right: 30px;"> 	
			</td>	
			<tr>
			  <td>	 Father:</td>
			  <td>
			<input type="text" name="fname" class="form-control" style="display: inline;margin-right: 30px;"> 	
			</td>
			</tr>
<tr>
			  <td>
			<button type="submit" class="btn btn-primary">Student Registration</button>
			</td>
			</tr>
			</table>
	</form>
	<hr/>
	
	
</div>

</body>
</html>
