package modelos;

public class Usuario {
	private int id;
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private String telefono;
	private float puntaje;
	private double latitud;
	private double longitud;
	
	public Usuario(int id, String usuario, String password, String nombre, String email, String telefono, float puntaje, double latitud, double longitud) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.puntaje = puntaje;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public int getId() {
		return id;
	}
	
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
}
