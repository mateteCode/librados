package conectaDB;

import enums.Tablas;
import enums.DB;

import modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaUsuarios {
	private final Tablas tabla = Tablas.usuarios;
	private final String db = DB.librados.toString();
	
	private final String cId = "id";
	private final String cUsuario = "usuario";
	private final String cPassword = "password";
	private final String cNombre = "nombre";
	private final String cEmail = "email";
	private final String cTelefono = "telefono";
	private final String cPuntaje = "puntaje";
	private final String cLatitud = "latitud";
	private final String cLongitud = "longitud";
	
	private final String SQLNuevoUsuario = "INSERT INTO " + tabla + "(usuario, password, nombre, email, telefono, puntaje, latitud, longitud) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	//private final String SQLLogin2 = "SELECT * FROM " + tabla  +" WHERE (" + cEmail + "= ? OR " + cUsuario + "= ? ) AND "+ cPassword +" = ?";
	private final String SQLLogin = "SELECT * FROM " + tabla  +" WHERE " + cEmail + " = ? AND "+ cPassword +" = ?";
	private final String SQLEliminarUsuario = "DELETE FROM " + tabla + " WHERE " + cId + " = ?;";
	private final String SQLActualizarUsuario = "UPDATE " + tabla + " SET password=?, nombre=?, email=?, telefono=?, latitud=?, longitud=? WHERE id=?;";
	
	public boolean agregarUsuario(Usuario usuario) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLNuevoUsuario);
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getPassword());
			pstm.setString(3, usuario.getNombre());
			pstm.setString(4, usuario.getEmail());
			pstm.setString(5, usuario.getTelefono());
			pstm.setDouble(6, usuario.getPuntaje());
			pstm.setDouble(7, usuario.getLatitud());
			pstm.setDouble(8, usuario.getLongitud());
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
	
	public Usuario getUserLogin(String email, String password){
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Usuario usuario = null;
        try {
        	pstm = con.prepareStatement(SQLLogin);
            pstm.setString(1, email);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
			while(rs.next()){
			    usuario = new Usuario(rs.getInt(cId), rs.getString(cUsuario), rs.getString(cPassword), rs.getString(cNombre), rs.getString(cEmail), rs.getString(cTelefono), rs.getFloat(cPuntaje), rs.getDouble(cLatitud), rs.getDouble(cLongitud));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        finally{
        	if(rs !=null) { try { rs.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
        return usuario;
    }
	
	public boolean eliminarUsuario(int id) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLEliminarUsuario);
			pstm.setInt(1, id);
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

	public boolean actualizarUsuario(Usuario usuario) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLActualizarUsuario);
			pstm.setString(1, usuario.getPassword());
			pstm.setString(2, usuario.getNombre());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getTelefono());
			pstm.setDouble(5, usuario.getLatitud());
			pstm.setDouble(6, usuario.getLongitud());
			pstm.setInt(7, usuario.getId());
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
	
}
