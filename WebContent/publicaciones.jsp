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
<!-- 		<table> -->
<%-- 		    <c:forEach items="${sessionScope.publicaciones}" var="p"> --%>
<!-- 		        <tr> -->
<%-- 		            <td>${p.id_ofrecido}</td> --%>
<%-- 		            <td>${p.imagenLibro}</td> --%>
<%-- 		            <td>${p.titulo} OK</td> --%>
<%-- 		            <td>${p.autor} OK</td> --%>
<%-- 		            <td>${p.usuario} OK</td> --%>
<%-- 		            <td>${p.imagenUsuario}</td> --%>
<%-- 		            <td>${p.puntajeUsuario} OK</td> --%>
<%-- 		            <td>${p.distanciaUsuario} OK</td> --%>
<%-- 		            <td>${p.puntajeLibro} OK</td> --%>
<%-- 		            <td>${p.saludLibro} OK</td> --%>
<%-- 		            <td>${p.nuevo}</td> --%>
<%-- 		            <td>${p.solicitado}</td> --%>
<%-- 		            <td>${p.numeroSolicitudes}</td> --%>
<%-- 		            <td>${p.tiempo} OK</td> --%>
<!-- 		        </tr> -->
<%-- 		    </c:forEach> --%>
<!--  		</table> -->

		<c:forEach items="${sessionScope.publicaciones}" var="p">
			<div class="container mx-auto px-20">
				<div style='background-color:rgb(255, 255, 255)'>
					<div class="bg-white rounded p-4 shadow md:flex justify-between" data-v-648b5d7b="" style="cursor: auto;">
	  					<div data-v-648b5d7b="">
	    					<a href="" data-v-648b5d7b="">
	      						<h4 class="text-2xl font-semibold" data-v-648b5d7b="">${p.titulo} (${p.puntajeLibro})</h4>
	   						</a>
	   						<p class="my-2 text-lg" data-v-648b5d7b="">${p.autor}</p>
	   						<p class="my-2" data-v-648b5d7b="">${p.usuario} (${p.puntajeUsuario})</p>
	   						<div class="flex items-center mt-4" data-v-648b5d7b="">
	   							<c:choose>
									<c:when test="${p.solicitado==true}">
										<div class="text-xs uppercase font-bold tracking-wider bg-green-300 inline-block px-2 py-1 rounded mr-2" data-v-648b5d7b="">
	                    					Solicitado (${p.numeroSolicitudes})
	               						</div>
									</c:when>
									<c:otherwise>
										<div class="text-xs uppercase font-bold tracking-wider bg-gray-300 inline-block px-2 py-1 rounded mr-2" data-v-648b5d7b="">
	                   						<a href='Index?accion=solicitar&id=${p.id_ofrecido}'>Solicitarlo (${p.numeroSolicitudes})</a>
	                					</div>
									</c:otherwise>
								</c:choose>
								<c:if test="${p.reservado == true}">
									<div class="text-xs uppercase font-bold tracking-wider bg-yellow-300 inline-block px-2 py-1 rounded mr-2" data-v-648b5d7b="">
	                   					Reservado
	                				</div>
								</c:if>
								<c:if test="${p.entregado == true}">
									<div class="text-xs uppercase font-bold tracking-wider bg-red-300 inline-block px-2 py-1 rounded mr-2" data-v-648b5d7b="">
	                    				Entregado
	               					</div>
								</c:if>
	    					</div>
	  					</div>
	  					<div class="text-right md:ml-8 flex items-center" data-v-648b5d7b="">
	    					<div class="flex md:block -mx-2 md:mx-0 mt-3 md:mt-0" data-v-648b5d7b="">
	      						<div class="flex justify-end mb-1 px-2 md:px-0" data-v-648b5d7b="">
	        						<div class="text-xl" data-v-648b5d7b="">${p.tiempo}</div>
	       							 <div class="ml-2" data-v-648b5d7b="">
	         							 <i class="fa-solid fa-clock text-xl"></i>
	       							 </div>
	     						 </div>
		     					 <div class="flex justify-end items-bottom mb-1 px-2 md:px-0" data-v-648b5d7b="">
		        					<div class="text-xl" data-v-648b5d7b="">${p.distanciaUsuario}</div>
		        					<div class="ml-2" data-v-648b5d7b="">
			          					<i class="fa-solid fa-location-dot text-xl"></i>
		        					</div>
		      					</div>
			     				 <div class="flex justify-end px-2 md:px-0" data-v-648b5d7b="">
			        				<div class="text-xl" data-v-648b5d7b="">${p.saludLibro}</div>
			        				<div class="ml-2" data-v-648b5d7b="">
			         					 <i class="fa-solid fa-book-medical text-xl"></i>
			        				</div>
			      				</div>
			    			</div>
			  			</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</main>
	<%@include file="/vistas/footer.html" %>
</body>
</html>