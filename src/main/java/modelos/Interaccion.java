package modelos;

public class Interaccion {
	private int id;
	private int id_ofrecido;
	private int id_usuario;
	private String usuario;
	private float puntaje;
	private String distancia;
	private String tiempo;
	private String autorLibro;
	private String tituloLibro;
	
	public Interaccion(int id, int id_ofrecido, int id_usuario, String usuario, float puntaje, String distancia,
			String tiempo, String autorLibro, String tituloLibro) {
		this.id = id;
		this.id_ofrecido = id_ofrecido;
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.puntaje = puntaje;
		this.distancia = distancia;
		this.tiempo = tiempo;
		this.autorLibro = autorLibro;
		this.tituloLibro = tituloLibro;
	}

	public int getId_ofrecido() {
		return id_ofrecido;
	}

	public void setId_ofrecido(int id_ofrecido) {
		this.id_ofrecido = id_ofrecido;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	
	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
}


