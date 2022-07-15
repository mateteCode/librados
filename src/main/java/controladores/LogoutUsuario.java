package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutUsuario")
public class LogoutUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "Deslogueado. Ya puede marcharse tranquilamente o debe entrar otra vez para continuar en el sitio";
		String url = "index.jsp";
		HttpSession session = request.getSession();
		//session.invalidate();
		session.setAttribute("usuario", null);
		session.setAttribute("mensaje", mensaje);
		//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		//rd.forward(request, response);
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
