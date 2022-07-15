package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conectaDB.TablaSolicitudes;
import conectaDB.TablaUsuarios;
import conectaDB.TablaVirtualInteraccion;
import conectaDB.TablaVirtualPublicacion;
import modelos.Usuario;
import modelos.Interaccion;
import modelos.Publicacion;
import modelos.Solicitud;

import java.util.List;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Index() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String mensaje = null;
		List<Publicacion> publicaciones = null;
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String accion = request.getParameter("accion");
		if(usuario !=null) {
			if(accion !=null) {
				switch(accion) {
					case "disponibles":
						TablaVirtualPublicacion consultaPublicacion = new TablaVirtualPublicacion();
						publicaciones = consultaPublicacion.getPublicaciones(usuario);
						session.setAttribute("publicaciones", publicaciones);
						url = "publicaciones.jsp";
						break;
					case "actualizarUsuario":
						TablaUsuarios consultaUsuarios = new TablaUsuarios();
						usuario.setUsuario(request.getParameter("usuario"));
						usuario.setPassword(request.getParameter("password"));
						usuario.setNombre(request.getParameter("nombre"));
						usuario.setEmail(request.getParameter("email"));
						usuario.setTelefono(request.getParameter("telefono"));
						usuario.setLatitud(Double.parseDouble(request.getParameter("latitud")));
						usuario.setLongitud(Double.parseDouble(request.getParameter("longitud")));
						if(consultaUsuarios.actualizarUsuario(usuario)) {
							session.setAttribute("usuario", usuario);
						}
						url = "misdatos.jsp";
						break;
					case "solicitar":
					{
						int id_ofrecido = Integer.parseInt(request.getParameter("id"));
						Solicitud solicitud =new Solicitud(0, id_ofrecido, usuario.getId(), null);
						TablaSolicitudes consultaSolicitudes = new TablaSolicitudes();
						consultaSolicitudes.agregarSolicitud(solicitud);
						// FALTA ACTUALIZAR PUBLICACIONES POR SESSION O LLAMADA
						url = "Index?accion=disponibles";
						break;
					}
					case "interacciones":
						TablaVirtualInteraccion consultaInteraccion = new TablaVirtualInteraccion();
						List<Interaccion> interacciones = consultaInteraccion.getInteracciones(usuario);
						List<Interaccion> reservas = consultaInteraccion.getReservas(usuario);
						List<Interaccion> entregas = consultaInteraccion.getEntregas(usuario);
						session.setAttribute("interacciones", interacciones);
						session.setAttribute("reservas", reservas);
						session.setAttribute("entregas", entregas);
						url="interacciones.jsp";
						break;
					case "reservar":
						int id_solicitud = Integer.parseInt(request.getParameter("id"));
						consultaInteraccion = new TablaVirtualInteraccion();
						consultaInteraccion.reservar(id_solicitud);
						//interacciones = consultaInteraccion.getInteracciones(usuario);
						//session.setAttribute("interacciones", interacciones);
						url="Index?accion=interacciones";
						break;
					case "entregar":
						int id_reserva = Integer.parseInt(request.getParameter("id"));
						int id_ofrecido = Integer.parseInt(request.getParameter("id_ofrecido"));
						consultaInteraccion = new TablaVirtualInteraccion();
						consultaInteraccion.entregar(id_reserva, id_ofrecido);
						url="Index?accion=interacciones";
				}
			}
			else {
				mensaje = "Bienvenido otra vez, " + usuario.getNombre();
				url = "index.jsp";
			}
		}
		else {
			url = "index.jsp";
			mensaje = "Debes entrar con tu cuenta o registrate para seguir en el sitio.";
		}

		session.setAttribute("mensaje", mensaje);
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
