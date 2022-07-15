<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Agregar libros</title>
	<%@include file="/vistas/head.html" %>
</head>
<body>
	<%@include file="/vistas/header.jsp" %>
	<main>
		<div class="form-content main">
			<form action="NewLibro" class="form bg-light" method="POST">
				<h1 class="text-center">Agregar Libro</h1>
				<div class="input-group">
					<i class="fa-solid fa-book fa-2x"></i>
					<input type="text" name="isbn" placeholder="ISBN" class="form-control" value="${sessionScope.libro.isbn}" required/>
				</div>
				<div class="input-group">
					<i class="fas fa-user fa-2x"></i>
					<input type="text" name="autor" placeholder="Autor" class="form-control" value="${sessionScope.libro.autor}" required/>
				</div>
				<div class="input-group">
					<i class="fa-solid fa-pen-to-square fa-2x"></i>
					<input type="text" name="titulo" placeholder="Titulo" class="form-control" value="${sessionScope.libro.titulo}" required/>
				</div>
				<div class="input-group">
					<i class="fa-regular fa-calendar fa-2x"></i>
					<input type="number" name="ano" placeholder="Año (2000)" class="form-control" value="${sessionScope.libro.año}" required/>
					
				</div>
				<div class="input-group">
					<i class="fa-solid fa-book-bookmark fa-2x"></i>
					<input type="number" min="1" max="30" step="1" name="edicion" placeholder="edicion (1)" class="form-control" value="${sessionScope.libro.edicion}" required/>
				</div>
				<div class="input-group">
					<i class="fa-solid fa-book-medical fa-2x"></i>
					<input type="number" min="1" max="5" step="0.5" name="salud" placeholder="Estado (1:muy roto a 5:nuevo)" class="form-control" required/>
				</div>
				<div class="input-submit">
					<input type="submit" class="btn btn-outline-primary btn-block" value="Agregar Libro"/>
				</div>
				
			</form>
		</div>
	</main>
	<%@include file="/vistas/footer.html" %>
</body>
</html>