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
				var paa=function(num) {
					num=num+5;
					console.log("Num = "+num);
				};
			paa(100);	

			jock(89,paa);

			function jock(num,navdeep){
				navdeep(num);
			}
			
	</script>
</body>
</html>
