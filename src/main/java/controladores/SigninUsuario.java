package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conectaDB.TablaUsuarios;
import modelos.Usuario;

@WebServlet("/SigninUsuario")
public class SigninUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SigninUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioNuevo = null;
		String url = "index.jsp";
		String mensaje = null;
		HttpSession session = request.getSession();
		//RequestDispatcher rd = null;
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		double latitud = Double.parseDouble(request.getParameter("latitud"));
		double longitud = Double.parseDouble(request.getParameter("longitud"));
		usuarioNuevo = new Usuario(0, usuario, password, nombre, email, telefono, 0, latitud, longitud);
		TablaUsuarios consultasUsuarios = new TablaUsuarios();
		if(consultasUsuarios.agregarUsuario(usuarioNuevo)) {
			mensaje = "Registro completado. Por favor, haga sesión para continuar.";
        	url = "login.jsp";
		}
		else {
			mensaje = "No se puedo registrar. Intente nuevamente.";
        	url = "registro.jsp";
		}
		session.setAttribute("mensaje", mensaje);
        //rd = request.getRequestDispatcher(url);
        //rd.forward(request, response);
        response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
