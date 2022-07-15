<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Busqueda IMDB</title>
	<%@include file="/vistas/head.html" %>
</head>
 <body>
 	
 	<%@include file="/vistas/header.jsp" %>
 	<div class="container flex flex-column shadow p-3 mb-5 mt-5 bg-body rounded">
 		<div class="form-content main">
 			<form method="POST" action="SearchLibro" class="form bg-light">
 				<h1 class="text-center">Busqueda de libro por ISBN</h1>
 				<div class="input-group">
 					<i class="fas fa-search fa-2x"></i>
 					<input type="text" name="isbn" placeholder="ISBN" class="form-control"/>
 				</div>
 				<input type="submit" class="btn btn-block btn-outline-primary mt-3" value="Buscar" /></form>
 		</div>
 	</div>
 	<%@include file="/vistas/footer.html" %>
    </body>
</html>