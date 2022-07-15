<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.mensaje != null}">
 	<div class="container alert alert-warning alert-dismissible fade show" role="alert">
 		${sessionScope.mensaje}
 		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
 		<c:remove var="mensaje" scope="session" />
	</div>
</c:if>