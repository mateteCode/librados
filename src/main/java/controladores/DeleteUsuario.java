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


@WebServlet("/DeleteUsuario")
public class DeleteUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TablaUsuarios consultasUsuarios = new TablaUsuarios();
		Usuario usuario = null;
		String url = "index.jsp";
		//RequestDispatcher rd = null;
		String mensaje = null;
		usuario = (Usuario) session.getAttribute("usuario");
		if(usuario != null) {
			if(consultasUsuarios.eliminarUsuario(usuario.getId())) {
	        	mensaje = "Usuario Eliminado";
	        	session.invalidate();
	        }
	        else {
	        	mensaje = "No es posible eliminar el usuario. Intentar mas tarde";
	        }
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
