package conectaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enums.DB;
import enums.Tablas;
import modelos.Libro;

public class TablaLibros {
	private final Tablas tabla = Tablas.libros;
	private final String db = DB.librados.toString();
	
	private final String cId = "id";
	private final String cIsbn = "isbn";
	private final String cAutor = "autor";
	private final String cTitulo = "titulo";
	private final String cAño = "año";
	private final String cEdicion = "edicion";
	private final String cPuntaje = "puntaje";
	
	private final String SQLNuevoLibro = "INSERT INTO " + tabla + "(isbn, autor, titulo, año, edicion, puntaje) VALUES (?, ?, ?, ?, ?, ?)";
	private final String SQLLibroPorImdb = "SELECT * FROM " + tabla + " WHERE isbn = ?;";
	
	public boolean agregarLibro(Libro libro) {
		boolean exito = false;
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(SQLNuevoLibro);
			pstm.setString(1, libro.getIsbn());
			pstm.setString(2, libro.getAutor());
			pstm.setString(3, libro.getTitulo());
			pstm.setInt(4, libro.getAño());
			pstm.setInt(5, libro.getEdicion());
			pstm.setFloat(6, libro.getPuntaje());
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
	
	public Libro getLibro(String isbn){
		Connection con = new ConexionDB(db).getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Libro libro = null;
        try {
        	pstm = con.prepareStatement(SQLLibroPorImdb);
            pstm.setString(1, isbn);
            rs = pstm.executeQuery();
			while(rs.next()){
			    libro = new Libro(rs.getInt(cId), rs.getString(cIsbn), rs.getString(cAutor), rs.getString(cTitulo), rs.getInt(cAño), rs.getInt(cEdicion), rs.getFloat(cPuntaje));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        finally{
        	if(rs !=null) { try { rs.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstm !=null) { try { pstm.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(con !=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
        return libro;
    }
}
