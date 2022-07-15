package modelos;

import java.time.LocalDateTime;

public class Ofrecido {
	private int id;
	private int id_libro;
	private int id_usuario;
	private LocalDateTime fecha;
	private float salud;
	
	public Ofrecido(int id, int id_libro, int id_usuario, LocalDateTime fecha, float salud) {
		this.id = id;
		this.id_libro = id_libro;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
		this.salud = salud;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public float getSalud() {
		return salud;
	}

	public void setSalud(float salud) {
		this.salud = salud;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}
}
