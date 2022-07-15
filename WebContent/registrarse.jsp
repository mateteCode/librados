<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registrarse a Librados</title>
	<%@include file="/vistas/head.html" %>
</head>
<body>
	<%@include file="/vistas/header.jsp" %>
	<main>
		<div class="container flex flex-column shadow p-3 mb-5 mt-5 bg-body rounded">
			<div class="container alert alert-warning alert-dismissible fade show" role="alert">
 				Para completar el registro es necesario la ubicación (no es necesario que sea real) de cada usuario.
 				Se proporcionan dos botones: Uno que usa la API de geocalización y otro que genera ubicaciones ficticias cercanas a la zona de AMBA.</br>
 				Terminado del registro, deberá ingresar con el correo electronico y contraseña elegidos.
 				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
			<div class="form-content main">
				<form action="SigninUsuario" class="form bg-light" method="POST">
					<h1 class="text-center">Registrar usuario</h1>
					<div class="input-group">
						<i class="fas fa-envelope fa-2x"></i>
						<input type="email" name="email" placeholder="Email" class="form-control" required/>
					</div>
					<div class="input-group">
						<i class="fas fa-lock fa-2x"></i>
						<input type="password" name="password" placeholder="Contraseña" class="form-control" required/>
					</div>
					<div class="input-group">
						<i class="fas fa-user fa-2x"></i>
						<input type="text" name="nombre" placeholder="Nombre de pila" class="form-control" required/>
					</div>
					<div class="input-group">
						<i class="fa fa-user-secret fa-2x"></i>
						<input type="text" name="usuario" placeholder="Nombre de Usuario" class="form-control" required/>
					</div>
					<div class="input-group">
						<i class="fas fa-phone fa-2x"></i>
						<input type="text" name="telefono" placeholder="Telefono (opcional)" class="form-control"/>
					</div>
					<div class="input-group">
						<i class="fas fa-map-marker-alt fa-2x"></i>
						<input type="text" name="latitud" id="latitud" placeholder="Ubicación: Latitud" class="form-control" required/>
					</div>
					<div class="input-group">
						<i class="fas fa-map-marker-alt fa-2x"></i>
						<input type="text" name="longitud" id="longitud" placeholder="Ubicación: Longitud" class="form-control" required/>
					</div>
					<div class="input-group mt-3">
						<button type="button" class="btn btn-outline-dark btn-block" onclick="getLocation();">Localizacion Real</button>
						<button type="button" class="btn btn-outline-dark btn-block" onclick="getFakeLocation();">Localizacion Aleatoria</button>
					</div>
					<input type="submit" class="btn btn-outline-primary mt-3" value="Registrarse"/>
				</form>
				
			</div>
		</div>
		
	</main>
	<%@include file="/vistas/footer.html" %>
	<script src="js/localizacion.js"></script>
</body>
</html>