package conectaDB;

import java.sql.*;

public class ConexionDB {
	private String url = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "";
	protected Connection conexion = null;
	
	public ConexionDB(String db) {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			url = url + db;
			conexion = DriverManager.getConnection(url, user, pass);
			
		}
		catch(SQLException error) {
			System.out.println("ERROR: No se puede conecta a la base de datos");
			error.printStackTrace();
		}
	}

	public Connection getConexion() {
		return conexion;
	}
}
