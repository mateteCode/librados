<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Insert title here</title>
	<%@include file="/vistas/head.html" %>
</head>
<body>
	<%@include file="/vistas/header.jsp" %>
	<main>
		<div class=container>
			<p> Si tenés libros que ya leíste, no te interesan o que te ocupan espacio, podés publicarlos para que tus vecinos puedan hacer uso de ellos.</p>
			<p> Cuando publicás un libro, tus vecinos podrán pedírtelo y tendrás que elegir a quien reservárselo para que lo retire<p>
			<p> La condición para elegir a quien dárserlo es tuya: por prioridad de quien te lo pidió primero, por cercanía o la razón que elijas</p>
			<p> Mientras esperás que esa persona lo retire, otros usuarios podrán pedirtelo hasta que finalmente lo entregas </p> 
		</div>
		<div class=container>
			<p> Ahora si lo que querés es aprovechar que otras personas ofrezcan sus libros, tendrás que ver el listado de libros disponibles, decidirte por cual(es) te puede(n) interesar.</p>
			<p> Podrás ver los que ya has solicitado, así como también el número de personas que ya lo han pedido<p>
			<p> La idea es que cuando te lo reservan, los retires lo antes posible para que el propietario no se arrepienta y se lo quiera dar a otra persona</p>
			<p> Ahora si has terminado el libro y ya no lo necesitás más, podrás hacerlo circular nuevamente en el sitio para se siga aprovechando. </p> 
		</div>
		<div class=container>
			<p> Para que la circulación de libros sea más efectiva, los usuarios al registrarse deben proporcionar su localización (real o aproximada) para que se calculen las distancias entre los distintos usuarios.</p>
			<p> Además, se podrán observar  el tiempo en las que fueron subidas las publicaciones<p>
			<p> Cuando te decidiste a publicar un libro, tendrás que buscarlo primer por su código ISBN internacional, para ver si ya está cargado en el sistema. En el caso que lo esté, solo tendrás que decir en cuál estado se encuentra, aportando un valor numérico (1: muy deteriorado, 5: impecable)</p>
			<p> Para ver quienes te solicitan los libros, miraras el menú "Interacciones" que contara con listado de personas que hay los han solicitado, a quienes elegiste para esperar a que lo retiren y también cuando ya hayas entrego </p> 
		</div>
<!-- 		<div> -->
<!-- 		<p>MENSAJE:</p> -->
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${sessionScope.mensaje != null}">${sessionScope.mensaje}</c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${sessionScope.usuario !=null}">${sessionScope.usuario.id}</c:when> --%>
<%-- 				<c:otherwise>NADIE</c:otherwise> --%>
<%-- 			</c:choose> --%>
<%-- 			<p><c:out value="${sessionScope.usuario.nombre}" /></p> --%>
<!-- 			<h3>Page attributes:</h3> -->
<!-- 			<table> -->
<%-- 		   		<c:forEach items="${requestScope}" var="p"> --%>
<!-- 		       		<tr> -->
<%-- 		           		<td>${p.key}</td> --%>
<%-- 		           		<td>${p.value}</td> --%>
<!-- 		      			 </tr> -->
<%-- 		   		</c:forEach> --%>
<!-- 			</table> -->
<!-- 		 	<h3>Session attributes:</h3> -->
<!-- 			<table> -->
<%-- 			    <c:forEach items="${sessionScope}" var="p"> --%>
<!-- 			        <tr> -->
<%-- 			            <td>${p.key}</td> --%>
<%-- 			            <td>${p.value}</td> --%>
<!-- 			        </tr> -->
<%-- 			    </c:forEach> --%>
<!-- 		 	</table> -->
<%-- 		 	<p><c:out value="${pageContext.request.requestURL}" /></p> --%>
<%-- 		 	<p><c:out value="${pageContext.request.servletPath}" /></p> --%>
<!-- 		</div> -->
	</main>
	<%@include file="/vistas/footer.html" %>
</body>
</html>