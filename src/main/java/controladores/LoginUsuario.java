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

@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginUsuario() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		TablaUsuarios consultasUsuarios = new TablaUsuarios();
		Usuario usuario = null;
		HttpSession session = request.getSession();
		String url = "Index?accion=disponibles";
		//RequestDispatcher rd = null;
		String mensaje = null;

        usuario = consultasUsuarios.getUserLogin(email, password);

		if (usuario != null) {
			mensaje = "Logueado";
			session = request.getSession();
			session.setMaxInactiveInterval(0);
			session.setAttribute("usuario", usuario);
		}
		else {
			mensaje = "Usuario Incorrecto. Intente nuevamente si tiene una cuenta o en caso contrario, debe registarse.";
        	url = "login.jsp";
        }
		session.setAttribute("mensaje", mensaje);
        //rd = request.getRequestDispatcher(url);
        //rd.forward(request, response);
        response.sendRedirect(url);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
