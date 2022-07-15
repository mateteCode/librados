package conectaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enums.DB;
import enums.Tablas;
import modelos.Solicitud;

public class TablaSolicitudes {
	private final Tablas tabla = Tablas.solicitudes;
	private final String db = DB.librados.toString();
	
	private final String SQLNuevoSolicitud = "INSERT INTO " + tabla + "(id, id_ofrecido, id_usuario) VALUES (null, ?, ?)";
	private final String SQLNumeroSolicitudes = "SELECT COUNT(id_ofrecido) FROM solicitudes WHERE id_ofrecido=?;";
	private final String SQLIsSolicitados = "SELECT * FROM solicitudes WHERE id_ofrecido=? AND id_usuario=?;";
	public boolean agregarSolicitud(Solicitud solicitud) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLNuevoSolicitud);
			pstm.setInt(1, solicitud.getId_ofrecido());
			pstm.setInt(2, solicitud.getId_usuario());
			System.out.println(SQLNuevoSolicitud);
			System.out.println(solicitud.getId_ofrecido());
			System.out.println(solicitud.getId_usuario());
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
	
	public int getNumeroSolicitudes(int id_ofrecido) {
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int cantidad = -1;
		try {
			pstm = con.prepareStatement(SQLNumeroSolicitudes);
			pstm.setInt(1, id_ofrecido);
			rs = pstm.executeQuery();
			while(rs.next()) {
				cantidad = rs.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		
		return cantidad;
	}
	
	public boolean isSolicitado(int id_ofrecido, int id_usuario) {
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean exito = false;
		try {
			pstm = con.prepareStatement(SQLIsSolicitados);
			pstm.setInt(1, id_ofrecido);
			pstm.setInt(2, id_usuario);
			rs = pstm.executeQuery();
			if(rs.next()) {
				exito = true;
			}
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
}
