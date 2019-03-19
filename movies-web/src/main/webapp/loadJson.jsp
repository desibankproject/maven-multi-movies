<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">

  		//loadData();
  		
  		function deleteRecord(mid){
			fetch('http://localhost:444/movie-spring-jdbc//delete/movie?mid='+mid).then(function(response) { 
  					return response.json();
  			}).then(function(data) {
	  			//{"message":23,"status":"success"}
				window.document.getElementById("message").innerHTML=data.message;
				//hide table......using javascript
				 document.getElementById("movie_"+mid).style.display="none";
  			});
  	  	}
  		
  		
  		function loadData() {
  			fetch('http://localhost:444/movie-spring-jdbc/movies/json').then(function(response) { 
  				//Reading raw jason data from body Convert to JavaScript object
  					return response.json();
  			}).then(function(data) {
  					console.log(data); 
  					var listdata="";
  					for(var x=0;x<data.length;x++) {
  						var item=data[x];
  						listdata=listdata+'<table class="table table-bordered"  id="movie_'+item.mid+'">';
  						listdata=listdata+'<tr>';
  						listdata=listdata+'<td>';
  						listdata=listdata+' <table class="table table-bordered">';
  						listdata=listdata+'<tbody>';
  						listdata=listdata+' <tr>';
  						listdata=listdata+'<td>Title</td>';
  						listdata=listdata+'<td>'+item.title+'</td>';
  						listdata=listdata+'</tr>';
  						listdata=listdata+'<tr>';
  						listdata=listdata+' <td>Director</td>';
  						listdata=listdata+'<td>'+item.director+'</td>';
  						listdata=listdata+'</tr>';
  						listdata=listdata+'<tr>';
  						listdata=listdata+'<td>Year</td>';
  						listdata=listdata+'<td>'+item.year+'</td>';
  						listdata=listdata+'</tr>';
  						listdata=listdata+'<tr>';
  						listdata=listdata+'<td>Language</td>';
  						listdata=listdata+'<td>'+item.language+'</td>';
  						listdata=listdata+'</tr>';
  						listdata=listdata+' <tr>';
  						listdata=listdata+'<td>Review</td>';
  						listdata=listdata+'<td>'+item.story+'</td>';
  						listdata=listdata+' </tr>';
  						listdata=listdata+' </tbody>';
  						listdata=listdata+'  </table>';
  						listdata=listdata+'	</td>';
  						listdata=listdata+'<td style="width: 30%;">';
  						listdata=listdata+'	  <table class="table table-borderless">';
  						listdata=listdata+'    <tbody>';
  						listdata=listdata+'  <tr>';
  						listdata=listdata+'<td>';
  						if(item.poster==null){
  							listdata=listdata+'	<img src="showPhoto?mid='+item.mid+'" style="height: 200px;" class="img-thumbnail" >';
  						}else{
  							listdata=listdata+'	<img src="'+item.poster+'" style="height: 200px;" class="img-thumbnail" >';
  	  	  				}
  				    			listdata=listdata+' <br/> <br/>';
  				    			listdata=listdata+'  <a href="editMovie?mid='+item.mid+'"><img src="img/edit.png" class="img-thumbnail" style="height: 50px;"></a>';
  				    			listdata=listdata+'  &nbsp;&nbsp;';
  				    			listdata=listdata+' <a href="javascript:deleteRecord('+item.mid+');"><img src="img/delete.png" class="img-thumbnail" style="height: 50px;"></a>';
  				    			listdata=listdata+'   </td>';
  				    			listdata=listdata+'  </tr>';
  				    			listdata=listdata+'  </tbody>';
  				    			listdata=listdata+'  </table>';
  				    			listdata=listdata+'</td>';
  				    			listdata=listdata+'	</tr>';
  				    			listdata=listdata+'  </table>';
  				    	}
					//alert(listdata);
					document.getElementById("showData").innerHTML=listdata;
  					
  			});
  	  	 }

  </script>
  
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <h2>Factorial of num</h2>
  
  <span id="message" style="font-size: 18px;color: red;"></span>
  
<img src="img/math.jpg"  style="height: 200px;">
  		<br/> 	<br/> 	
  		<button type="button" class="btn btn-primary" onclick="loadData();">Load Data Now!</button>
  		<br/> 
  		<hr/>
  		<h2>Movies Lists</h2>
  		<div  id="showData">
  		
  		</div>
  	
</div>

</body>
</html>
