<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Registrarse a Librados</title>
	<%@include file="/vistas/head.html" %>
</head>
<body>
	<%@include file="/vistas/header.jsp" %>
	<main>
		<c:if test="${sessionScope.usuario ==null}">
			<c:set var="mensaje" value="Ha perdido la sesión. Debe iniciar sesión para continuar." scope="session" />
			<c:redirect url="login.jsp"/>
		</c:if>
		<div class="container flex flex-column shadow p-3 mb-5 mt-5 bg-body rounded">
			<div class="form-content main">
				<form action="Index?accion=actualizarUsuario" class="form bg-light" method="POST">
					<h1 class="text-center">Mis datos</h1>
					<div class="input-group">
						<i class="fas fa-envelope fa-2x"></i>
						<input type="email" name="email" placeholder="Email" class="form-control" required value="${sessionScope.usuario.email}"/>
					</div>
					<div class="input-group">
						<i class="fas fa-lock fa-2x"></i>
						<input type="password" name="password" placeholder="Contraseña" class="form-control" value="${sessionScope.usuario.password}" required />
					</div>
					<div class="input-group">
						<i class="fas fa-user fa-2x"></i>
						<input type="text" name="nombre" placeholder="Nombre de pila" class="form-control" required value="${sessionScope.usuario.nombre}">
					</div>
					<div class="input-group">
						<i class="fa fa-user-secret fa-2x"></i>
						<input type="text" name="usuario" placeholder="Nombre de Usuario" class="form-control" readonly required value="${sessionScope.usuario.usuario}"/>
					</div>
					<div class="input-group">
						<i class="fas fa-phone fa-2x"></i>
						<input type="text" name="telefono" placeholder="Telefono (opcional)" class="form-control" value="${sessionScope.usuario.telefono}"/>
					</div>
					<div class="input-group">
						<i class="fas fa-map-marker-alt fa-2x"></i>
						<input type="text" name="latitud" id="latitud" placeholder="Ubicación: Latitud" class="form-control" required value="${sessionScope.usuario.latitud}"/>
					</div>
					<div class="input-group">
						<i class="fas fa-map-marker-alt fa-2x"></i>
						<input type="text" name="longitud" id="longitud" placeholder="Ubicación: Longitud" class="form-control" required value="${sessionScope.usuario.longitud}"/>
					</div>
					<div class="input-group mt-3">
						<button type="button" class="btn btn-outline-dark btn-block" onclick="getLocation();">Localizacion Real</button>
						<button type="button" class="btn btn-outline-dark btn-block" onclick="getFakeLocation();">Localizacion Aleatoria</button>
					</div>
					<input type="submit" class="btn btn-outline-primary mt-3" value="Actualizar"/>
				</form>
				
			</div>
		</div>
		
	</main>
	<%@include file="/vistas/footer.html" %>
	<script src="js/localizacion.js"></script>
</body>
</html>