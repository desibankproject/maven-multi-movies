<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    		<style type="text/css">
  		.zoomimg {
						    display: inline-block;
						    height: 200px;
						    padding: 0px 5px 0px 5px;
						    background-size: 100% 100%;
						    background-repeat: no-repeat;
						    background-position: center center;
						    transition: all .5s ease;
		}
	.zoomimg:hover {
  			    cursor: pointer;
    			transform: scale(2.0);
	  }
  		
  		</style>
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
 <%@include file="header.jsp" %>
  	<br/> 
  	<!-- <form action="searchMovie" method="get">
			Title :
			<input type="text" name="title" class="form-control" style="width: 50%;display: inline;margin-right: 30px;"> 	
			<button type="submit" class="btn btn-primary">Search Movie</button>
			<button type="Reset" class="btn btn-danger">Clear</button>
	</form> -->
	<hr/>
	  <p style="font-weight: bold;color: red;">Movie Search Result(s)</p>            
  
  
  <c:forEach items="${magicResults}" var="movie">
    <table class="table table-bordered">
    	<tr>
    		<td>
    		
    		  <table class="table table-bordered">
    <tbody>
     <tr>
        <td>Title</td>
        <td>${movie.title}</td>
      </tr>
      <tr>
        <td>Director</td>
       <td>${movie.director}</td>
      </tr>
      <tr>
        <td>Year</td>
         <td>${movie.year}</td>
      </tr>
      <tr>
        <td>Language</td>
          <td>${movie.language}</td>
      </tr>
      <tr>
        <td>Review</td>
          <td>${movie.story}</td>
      </tr>
    </tbody>
  </table>
  <img src="img/movie-type.png" class="img-thumbnail" style="height: 50px;"> <b>Movie Types  :</b>  
  		 
  		 <div id="typessection">
  		 <c:forEach items="${movie.types}" var="type">
                                 <span id="movietype_${type.mtid}">  		 																																																										
   									<a href="javascript:deleteType(${type.mtid});"><img src="img/delete.png" class="img-thumbnail" style="height: 30px;"> </a> ${type.name},
   								</span>
   			</c:forEach>
    		</div>			
    		</td>
    		
    	<td style="width: 30%;">
    	
    	  <table class="table table-borderless">
    <tbody>
     <tr>
        <td>
        
        <c:if test="${empty movie.poster}">
        		<img src="showPhoto?mid=${movie.mid}" class="zoomimg" >
		</c:if>
		<c:if test="${not empty movie.poster}">
    			<img src="${movie.poster}" class="zoomimg" >
		</c:if>
        
        
        <br/> <br/>
        <a href="editMovie?mid=${movie.mid}"><img src="img/edit.png" class="img-thumbnail" style="height: 50px;"></a>
        &nbsp;&nbsp;
          <a href="deleteMovie?mid=${movie.mid}"><img src="img/delete.png" class="img-thumbnail" style="height: 50px;"></a>
            &nbsp;&nbsp;
          <a href="javascript:openMovieTypeModal('${movie.mid}','${movie.title}');"><img src="img/movie-type.png" class="img-thumbnail" style="height: 50px;"></a>
        </td>
      </tr>
    </tbody>
  </table>
    		</td>
    		
    	</tr>
    
    </table>
</c:forEach>
	
	
</div>

<!-- The Modal -->

<form method="post"  id="addMovieTypeForm">
<div class="modal" id="movieTypeModal">
  <div class="modal-dialog">
    <div class="modal-content" style="margin-top: 150px;">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add Movie Type</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      		<input id="mid" name="mid" type="hidden">
     		<div class="form-group">
     				<span style="color:red;font-weight: bold;" id="popupMessage"></span>
     				 <br/>
     				<label>Title</label>
     				<input name="mtitle" id="mtitle" class="form-control" value="Hero" readonly="readonly">
     		</div>
     		
     			<div class="form-group">
     				<label>Type</label>
     				<select name="name" id="tname" class="form-control">
     					<option>Blueray</option>	
     					<option>HD</option>	
     					<option>3D</option>	
     					<option>DVD</option>	
     				</select>
     		</div>
     
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      <button type="button" class="btn btn-primary"  onclick="addMovieType();">Add  Type</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</form>

<script type="text/javascript">
	function deleteType(mtid) {
		//Submitting request to to this delete-movie-type with get method
		//http://localhost:4554/movies-spring-jdbc/v3/movies/types/9882
		var contextPath="${pageContext.request.contextPath}";
	//	window.location.href="delete-movie-type?mtid="+mtid;
		var request = new Request(contextPath+'/v3/movies/types/'+mtid, {
									method: 'DELETE', 
									headers: new Headers({
												'Accept': 'application/json'
									})
		});
			// Now use it!
		fetch(request).then(function(response) { 
				return response.json();
		}).then(function(data) {
                //jQuery - This is short cut for JavaScript or you  can say that it is library for JavaScript 
			    $("#movietype_"+mtid).hide();
		}); 
	}	
	
	function openMovieTypeModal(mid,title){
		$("#popupMessage").html("");
		document.getElementById("mtitle").value=title;
		document.getElementById("mid").value=mid;
		$("#movieTypeModal").modal('show');
	}

	function addMovieType(){
				var typeName=$("#tname").val();
				var pmid=$("#mid").val();
				var obj={name:typeName,mid:pmid};
				var contextPath="${pageContext.request.contextPath}";
				var jsonData=JSON.stringify(obj);
				var request = new Request(contextPath+"/v3/movies/types", {
					method: 'POST', 
					body:jsonData, 
					headers: new Headers({
						'Content-Type': 'application/json',
						'Accept': 'application/json'
					})
				});
				
				// Now use it!
				fetch(request).then(function(response) { 
						return response.json();
				}).then(function(data) {
					  if(data.status=="success") {
							  var mtid=data.num;
							  var typeData="";
							  //Here we are generating span in JavaScript
							  typeData=typeData+'<span id="movietype_'+mtid+'">';  		 																																																										
							  typeData=typeData+'<a href="javascript:deleteType('+mtid+');"><img src="img/delete.png" class="img-thumbnail" style="height: 30px;"> </a> '+typeName;  	
							  typeData=typeData+'</span>'; 
				               console.log(typeData);
				               $("#typessection").append(typeData);
				               $("#movieTypeModal").modal('hide');
					}else{
							$("#popupMessage").html(data.message);
					}
				}); 
	}

</script>

</body>
</html>
