package conectaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import enums.DB;
import enums.Tablas;
import modelos.Libro;
import modelos.Ofrecido;
import modelos.Usuario;

public class TablaOfrecidos {
	private final Tablas tabla = Tablas.ofrecidos;
	private final String db = DB.librados.toString();
	
	private final String SQLNuevoOfrecido = "INSERT INTO " + tabla + "(id, id_libro, id_usuario, salud) VALUES (null, ?, ?, ?)";

	
	public boolean agregarOfrecido(Ofrecido ofrecido, Libro libro, Usuario usuario) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLNuevoOfrecido);
			System.out.println(libro.getId());
			System.out.println(usuario.getId());
			System.out.println(ofrecido.getSalud());
			pstm.setInt(1, libro.getId());
			pstm.setInt(2, usuario.getId());
			pstm.setFloat(3, ofrecido.getSalud());
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
	
	public List<Ofrecido> getOfrecidos(int id_usuario) {
		List<Ofrecido> ofrecidos = null;
		
		return ofrecidos;
	}
}
