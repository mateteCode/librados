<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="Index">
        	<i class="fa-solid fa-book-open-reader fa-2x d-inline-block align-middle"></i><span class="d-inline-block">LIBRADOS</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href='index.jsp'>Inicio</a>
		        </li>
		        <c:choose>
					<c:when test="${sessionScope.usuario !=null}">
						<li class="nav-item">
				          <a class="nav-link" href='Index?accion=disponibles'>Disponibles</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="Index?accion=interacciones">Interacciones</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href='busquedaISBN.jsp'>Publicar</a>
				        </li>
					</c:when>
				</c:choose>
            </ul>
            <ul class="navbar-nav">
            	<c:choose>
					<c:when test="${sessionScope.usuario ==null}">
						<li class="nav-item">
				          <a class="nav-link" href=login.jsp>Entrar</a>
				        </li>
				        <li class="nav-item dropdown">
				        <li class="nav-item">
				          <a class="nav-link" href='registrarse.jsp'>Registrarse</a>
				        </li>
					</c:when>
					<c:otherwise>
						<li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            <i class="fa-solid fa-circle-user"></i>${sessionScope.usuario.usuario}
				          </a>
				          <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
				            <li><a class="dropdown-item" href="misdatos.jsp">Mi datos</a></li>
				            <li><a class="dropdown-item" href='DeleteUsuario'>Eliminar cuenta</a></li>
				            <li>
				            	<hr class="dropdown-divider">
			                </li>
			                <li><a class="dropdown-item" href='LogoutUsuario'>Desloguearse</a></li>
				          </ul>
				        </li>
					</c:otherwise>
			</c:choose>
                
		        
            </ul>
        </div>
    </div>
</nav>
</header>


