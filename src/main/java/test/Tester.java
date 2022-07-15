package test;
import java.sql.Connection;

import conectaDB.ConexionDB;
import enums.Tablas;

public class Tester {

	public static void main(String [] args) {
		Tablas tabla = Tablas.usuarios;
		Connection con = new ConexionDB("librados").getConexion();
		System.out.println(tabla);
	}
}


