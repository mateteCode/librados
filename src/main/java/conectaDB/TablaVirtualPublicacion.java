package conectaDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import enums.DB;
import enums.Tablas;
import modelos.Publicacion;
import modelos.Usuario;
import utils.Distancia;
import utils.Tiempo;

public class TablaVirtualPublicacion {
	private final String db = DB.librados.toString();
	private final String SQLPublicaciones = "SELECT * FROM ofrecidos JOIN libros ON ofrecidos.id_libro = libros.id JOIN usuarios ON ofrecidos.id_usuario = usuarios.id ORDER BY ofrecidos.fecha DESC;";

	public List<Publicacion> getPublicaciones(Usuario usuario) {
		List<Publicacion> publicaciones = null;
		Statement stm = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = new ConexionDB(db).getConexion();
			stm = con.createStatement();
			rs = stm.executeQuery(SQLPublicaciones);
			publicaciones = new ArrayList<>();
			while(rs.next()){
				int id_ofrecido = rs.getInt(1);
				String tiempo = Tiempo.periodo(rs.getTimestamp(4).toLocalDateTime());
				float saludLibro = rs.getFloat(5);
				String autor = rs.getString(8);
				String titulo = rs.getString(9);
				int anio = rs.getInt(10);
				String edicion = String.valueOf(rs.getInt(11)) + "a edición";
				float puntajeLibro = rs.getFloat(12);
				String usuarioLibro = rs.getString(15);
				float puntajeUsuario = rs.getFloat(20);
				double latitud = rs.getDouble(21);
				double longitud = rs.getDouble(22);
				String distanciaUsuario = Distancia.haversine(longitud, latitud, usuario.getLongitud(), usuario.getLatitud());
				
				// IMPLEMENTAR
				// -------------
				boolean nuevo = false;
				String imagenLibro = null;
				String imagenUsuario = null;
				// --------------
				
				TablaSolicitudes consultaSolicitudes = new TablaSolicitudes();
				int numeroSolicitados = consultaSolicitudes.getNumeroSolicitudes(id_ofrecido);
				boolean solicitado = consultaSolicitudes.isSolicitado(id_ofrecido, usuario.getId());
				TablaVirtualInteraccion consultaInteraccion = new TablaVirtualInteraccion();
				boolean reservado = consultaInteraccion.isReservado(id_ofrecido);
				boolean entregado = false;
				
				Publicacion publicacion = new Publicacion(id_ofrecido, imagenLibro, titulo, autor, usuarioLibro,
						imagenUsuario, puntajeUsuario, distanciaUsuario, puntajeLibro, saludLibro,
						nuevo, solicitado, numeroSolicitados, tiempo, reservado, entregado, edicion, anio);
				publicaciones.add(publicacion);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(stm !=null) { try { stm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}

		return publicaciones;
	}
}
