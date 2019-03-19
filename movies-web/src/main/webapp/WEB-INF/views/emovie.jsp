<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "sf"%>
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
  <%@include file="header.jsp" %>
  	<br/> 	<br/> 	<br/> 
  	<sf:form action="updateMovie" method="post" modelAttribute="danger"   enctype="multipart/form-data">
  			<sf:hidden path="mid" /> 
			Title :
			<sf:input  class="form-control" style="width: 50%"  path="title" /> 	
			<br/> 	
			Year :
			<sf:select path="year"  class="form-control" style="width: 50%">
					<sf:options items="${yearOptions}"/> 
			</sf:select>
			<br/> 	
				Director :
			<sf:input  path="director" class="form-control" style="width: 50%"/> 	
			<br/> 	
			Language :
			<sf:select path="language"  class="form-control" style="width: 50%">
				<sf:options items="${languageOptions}"/> 
			</sf:select>
			<br/> 	
			Poster :
			<input type="file" name="photo" class="form-control" style="width: 80%"> 
			<c:if test="${empty danger.poster}">
        		<img src="showPhoto?mid=${danger.mid}" style="height: 200px;" class="img-thumbnail" >
		</c:if>
		<c:if test="${not empty danger.poster}">
    			<img src="${danger.poster}" style="height: 200px;" class="img-thumbnail">
		</c:if>
				
			<br/> 	
				Story  :
				<textarea  name="story" rows="4" cols=""  class="form-control" style="width: 50%">${danger.story}</textarea>
			<br/> 	
			<button type="submit" class="btn btn-primary">Update Movie</button>
	</sf:form>
	<hr/>
	
</div>

</body>
</html>
