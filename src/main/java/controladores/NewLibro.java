package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conectaDB.TablaLibros;
import conectaDB.TablaOfrecidos;
import modelos.Libro;
import modelos.Ofrecido;
import modelos.Usuario;

@WebServlet("/NewLibro")
public class NewLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewLibro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro libro = null;
		Usuario usuario = null;
		String url = "Index?accion=disponibles";
		String mensaje = null;
		float salud = -1;
		String isbn = request.getParameter("isbn");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		int ano = Integer.parseInt(request.getParameter("ano"));
		int edicion = Integer.parseInt(request.getParameter("edicion"));
		salud = Float.parseFloat(request.getParameter("salud"));
		
		HttpSession session = request.getSession();
		usuario = (Usuario) session.getAttribute("usuario");
		libro = (Libro) session.getAttribute("libro");
		
		TablaLibros consultaLibros= new TablaLibros();
		
		if(libro == null) {
			libro = new Libro(isbn, autor, titulo, ano, edicion);
			consultaLibros.agregarLibro(libro);
			libro = consultaLibros.getLibro(isbn);
		}
		if(salud != -1) {
			TablaOfrecidos consultaOfrecidos = new TablaOfrecidos();
			Ofrecido ofrecido = new Ofrecido(0, libro.getId(), usuario.getId(), null, salud);
			consultaOfrecidos.agregarOfrecido(ofrecido, libro, usuario);
		}
		session.setAttribute("libro", null);
		session.setAttribute("mensaje", mensaje);
        response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
