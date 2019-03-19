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
  <h2>Function Expression</h2>
<img src="img/math.jpg"  style="height: 200px;">
  	</div>

	<script type="text/javascript">
		      //creating object inside JavaScript
		      //Function Constructor
		       function Customer(name,email,gender) {
						this.name=name;
						this.email=email;
						this.gender=gender;
						this.show=function(){
							console.log(this.name);
							console.log(this.email);
							console.log(this.gender);
							console.log(this);
					   }
			   }
			   var cust1=new Customer("Nagendra","na@gmail.com","Male");
			   var cust2=new Customer("Rock","rock@gmail.com","Male");
			   cust1.show();
			   cust2.show();
			   
	</script>
</body>
</html>
