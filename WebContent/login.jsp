<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<%@include file="/vistas/head.html" %>
</head>
 <body>
 		<%@include file="/vistas/header.jsp" %>
 		<div class="container flex flex-column shadow p-3 mb-5 mt-5 bg-body rounded">
 			<%@include file="/vistas/error.jsp" %>
 			<div class="form-content main container">
	 			<form method="POST" action="LoginUsuario" class="form bg-light p-5">
	 				<h1 class="text-center">Ingresar</h1>
	 				<div class="input-group">
	 					<i class="fas fa-envelope fa-2x"></i>
	 					<input type="email" name="email" placeholder="Correo Electrónico" class="form-control" required/>
	 				</div>
	 				<div class="input-group">
	 					<i class="fas fa-lock fa-2x"></i>
	 					<input type="password"  name="password" placeholder="Contraseña" class="form-control" required/>
	 				</div>
	 				<input type="submit" class="btn btn-block btn-outline-primary mt-3" value="Login" />
	 				<div class="container">
	 					<p class="fs-6">Si no tiene una cuenta, puede <a href="registrarse.jsp">registarse</a></p>
	 				</div>
	 			</form>
 			</div>
 			
 		</div>
 		
 	<%@include file="/vistas/footer.html" %>
    </body>
</html>
