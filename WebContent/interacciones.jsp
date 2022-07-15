<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="modelos.Usuario"%>
<%@ page import="java.lang.*"%>
<html>
<head>
	<title>Insert title here</title>
	<%@include file="/vistas/head.html" %>
<!-- 	<script defer src="js/main.js"></script> -->
	<!-- Vue -->
<!-- 	<script defer src="js/components/cardProduct.js"></script> -->
<!-- 	<script defer src="js/mainVue.js"></script> -->
<link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700" type="text/css" rel="stylesheet">
<link href="https://atymic.dev/assets/css/0.styles.eee9f37c.css" type="text/css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>

<style>
	td {
		padding: 10px;
		
	}
	.container {
  			margin-top:1rem;

		}
</style>
</head>
<body>
	<%@include file="/vistas/header.jsp" %>
	<main>
		<div class="container">
			<h3>Solicitudes</h3>
			<c:choose>
				<c:when test="${sessionScope.interacciones.size() > 0}">
					<table class="table table-striped">
					    <c:forEach items="${sessionScope.interacciones}" var="p">
					        <tr>
					        	<td>${p.autorLibro}</td>
					            <td>${p.tituloLibro}</td>
		<%-- 			            <td>${p.id}</td> --%>
		<%-- 			            <td>${p.id_ofrecido}</td> --%>
		<%-- 			            <td>${p.id_usuario}</td> --%>
					            <td>${p.usuario} (${p.puntaje})</td>
					            <td>${p.distancia}</td>
					            <td>${p.tiempo}</td>
					            <td><a href="Index?accion=reservar&id=${p.id}">Reservar</a></td>
					        </tr>
					    </c:forEach>
		 			</table>
				</c:when>
				<c:otherwise>
					No hay ninguna.
				</c:otherwise>
			</c:choose>
			<br><br><br>
			
			<h3>Reservas</h3>
			<c:choose>
				<c:when test="${sessionScope.interacciones.size() > 0}">
					<table class="table table-striped">
					    <c:forEach items="${sessionScope.reservas}" var="p">
					        <tr>
					        	<td>${p.autorLibro}</td>
					            <td>${p.tituloLibro}</td>
		<%-- 			            <td>${p.id}</td> --%>
		<%-- 			            <td>${p.id_ofrecido}</td> --%>
		<%-- 			            <td>${p.id_usuario}</td> --%>
					            <td>${p.usuario} (${p.puntaje})</td>
					            <td>${p.distancia}</td>
					            <td>${p.tiempo}</td>
					            <td><a href="Index?accion=entregar&id=${p.id}">Entregar</a></td>
					        </tr>
					    </c:forEach>
		 			</table>
		 		</c:when>
				<c:otherwise>
					No hay ninguna.
				</c:otherwise>
			</c:choose>
			<br><br><br>
			
			<h3>Entregas</h3>
			No hay ninguna.
			<br><br><br>
		</div>
		
		

	</main>
	<%@include file="/vistas/footer.html" %>
</body>
</html>