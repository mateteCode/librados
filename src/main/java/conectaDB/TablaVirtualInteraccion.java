package conectaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import enums.DB;
import enums.Tablas;
import modelos.Interaccion;
import modelos.Usuario;
import utils.Distancia;
import utils.Tiempo;

public class TablaVirtualInteraccion {
	private final String db = DB.librados.toString();
	private Tablas tabla = null;
	//private final String SQLPublicaciones = "";
	//private final String SQLAgregar = "SELECT " + tabla + ".id, id_ofrecido, id_usuario, usuario, puntaje, latitud, longitud, " + tabla + ".fecha FROM solicitudes JOIN usuarios ON id_usuario = usuarios.id ORDER BY id_ofrecido ASC, solicitudes.fecha DESC;";
	//private final String SQLInteraccion = "SELECT solicitudes.id, id_ofrecido, solicitudes.id_usuario, usuario, puntaje, latitud, longitud, solicitudes.fecha FROM solicitudes JOIN ofrecidos ON solicitudes.id_ofrecido = ofrecidos.id JOIN USUARIOS ON solicitudes.id_usuario = usuarios.id  WHERE ofrecidos.id_usuario = ? ORDER BY id_ofrecido ASC, solicitudes.fecha DESC;";
	private final String SQLInteraccion = "SELECT solicitudes.id, id_ofrecido, solicitudes.id_usuario, usuario, usuarios.puntaje, latitud, longitud, solicitudes.fecha, libros.autor, libros.titulo FROM solicitudes JOIN ofrecidos ON solicitudes.id_ofrecido = ofrecidos.id JOIN usuarios ON solicitudes.id_usuario = usuarios.id JOIN libros ON ofrecidos.id_libro = libros.id WHERE ofrecidos.id_usuario = ? ORDER BY id_ofrecido ASC, solicitudes.fecha DESC;";
	private final String SQLInteraccion2 = "SELECT reservas.id, id_ofrecido, reservas.id_usuario, usuario, usuarios.puntaje, latitud, longitud, reservas.fecha, libros.autor, libros.titulo FROM reservas JOIN ofrecidos ON reservas.id_ofrecido = ofrecidos.id JOIN usuarios ON reservas.id_usuario = usuarios.id JOIN libros ON ofrecidos.id_libro = libros.id WHERE ofrecidos.id_usuario = ? ORDER BY id_ofrecido ASC, reservas.fecha DESC;";
	private String SQLAgregar = "INSERT INTO " + tabla + "(id, id_ofrecido, id_usuario) VALUES (null, ?, ?)";
	private final String SQLReservar1 = "INSERT INTO reservas(id_ofrecido, id_usuario) SELECT id_ofrecido, id_usuario FROM solicitudes WHERE id=?;";
	private final String SQLReservar2 = "DELETE FROM solicitudes WHERE id=?";
	private final String SQLisReservado = "SELECT * FROM reservas JOIN ofrecidos ON reservas.id_ofrecido = ofrecidos.id WHERE id_ofrecido = ?;";
	
	public TablaVirtualInteraccion(Tablas tabla) {
		this.tabla = tabla;
	}
	public TablaVirtualInteraccion() {
		this.tabla = Tablas.reservas;
	}
	
	public boolean agregar(int id_solicitud, int id_usuario) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLAgregar);
			pstm.setInt(1, id_solicitud);
			pstm.setInt(2, id_usuario);
			pstm.execute();
			exito = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return exito;
	}
	
	public List<Interaccion> getInteracciones(Usuario miUsuario) {
		List<Interaccion> interacciones = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = new ConexionDB(db).getConexion();
			pstm = con.prepareStatement(SQLInteraccion);
			pstm.setInt(1, miUsuario.getId());
			rs = pstm.executeQuery();
			interacciones = new ArrayList<>();
			while(rs.next()){
				int id_interaccion = rs.getInt(1);
				int id_ofrecido = rs.getInt(2);
				int id_usuario = rs.getInt(3);
				String usuario = rs.getString(4);
				float puntajeUsuario = rs.getFloat(5);
				double latitud = rs.getDouble(6);
				double longitud = rs.getDouble(7);
				String tiempo = Tiempo.periodo(rs.getTimestamp(8).toLocalDateTime());
				String autor = rs.getString(9);
				String titulo = rs.getString(10);
				String distanciaUsuario = Distancia.haversine(longitud, latitud, miUsuario.getLongitud(), miUsuario.getLatitud());
				Interaccion interaccion = new Interaccion(id_interaccion,id_ofrecido, id_usuario, usuario, puntajeUsuario, distanciaUsuario, tiempo, autor, titulo);
				interacciones.add(interaccion);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return interacciones;
	}
	
	public List<Interaccion> getReservas(Usuario miUsuario) {
		List<Interaccion> reservas = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = new ConexionDB(db).getConexion();
			pstm = con.prepareStatement(SQLInteraccion2);
			pstm.setInt(1, miUsuario.getId());
			rs = pstm.executeQuery();
			reservas = new ArrayList<>();
			while(rs.next()){
				int id_reserva = rs.getInt(1);
				int id_ofrecido = rs.getInt(2);
				int id_usuario = rs.getInt(3);
				String usuario = rs.getString(4);
				float puntajeUsuario = rs.getFloat(5);
				double latitud = rs.getDouble(6);
				double longitud = rs.getDouble(7);
				String tiempo = Tiempo.periodo(rs.getTimestamp(8).toLocalDateTime());
				String autor = rs.getString(9);
				String titulo = rs.getString(10);
				String distanciaUsuario = Distancia.haversine(longitud, latitud, miUsuario.getLongitud(), miUsuario.getLatitud());
				Interaccion reserva = new Interaccion(id_reserva,id_ofrecido, id_usuario, usuario, puntajeUsuario, distanciaUsuario, tiempo, autor, titulo);
				reservas.add(reserva);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return reservas;
	}
	
	public boolean reservar(int id_solicitud) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		try {
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(SQLReservar1);
			pstm1.setInt(1, id_solicitud);
			pstm1.execute();
			pstm2 = con.prepareStatement(SQLReservar2);
			pstm2.setInt(1, id_solicitud);
			pstm2.execute();
			con.commit();
			exito = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstm1 !=null) { try { pstm1.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstm2 !=null) { try { pstm2.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return exito;
	}
	
	public boolean isReservado(int id_solicitud) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm= null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(SQLisReservado);
			pstm.setInt(1, id_solicitud);
			rs = pstm.executeQuery();
			if(rs.next()) {
				exito = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(rs !=null) { try { rs.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return exito;
	}
	
}
