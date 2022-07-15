package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conectaDB.TablaLibros;
import modelos.Libro;

@WebServlet("/SearchLibro")
public class SearchLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		TablaLibros consultasLibros = new TablaLibros();
		Libro libro = null;
		HttpSession session = request.getSession();
		String url = "libronuevo.jsp";
		String mensaje = null;
		
		libro = consultasLibros.getLibro(isbn);

		if (libro != null) {
			mensaje = "Libro existente. Ya puede publicarlo";
			//url = "publicarlibro.jsp";
		}
		else {
			mensaje = "Este libro nunca ha sido publicado. Por favor, primero llene los datos del libro";
        }
		session.setAttribute("mensaje", mensaje);
		session.setAttribute("libro", libro);
        response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
