package modelos;

import java.time.LocalDateTime;

public class Solicitud {
	int id;
	int id_ofrecido;
	int id_usuario;
	LocalDateTime fecha;
	
	public Solicitud(int id, int id_ofrecido, int id_usuario, LocalDateTime fecha) {
		this.id = id;
		this.id_ofrecido = id_ofrecido;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ofrecido() {
		return id_ofrecido;
	}

	public void setId_ofrecido(int id_publicacion) {
		this.id_ofrecido = id_publicacion;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
}
