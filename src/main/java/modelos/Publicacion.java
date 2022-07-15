package modelos;

public class Publicacion {
	private int id_ofrecido;
	private String imagenLibro;
	private String titulo;
	private String autor;
	private String usuario;
	private String imagenUsuario;
	private float puntajeUsuario;
	private String distanciaUsuario;
	private float puntajeLibro;
	private float saludLibro;
	private boolean nuevo;
	private boolean solicitado;
	private int numeroSolicitudes;
	private String tiempo;
	private boolean reservado;
	private boolean entregado;
	private String edicion;
	private int anio;

	public Publicacion(int id_ofrecido, String imagenLibro, String titulo, String autor, String usuario,
			String imagenUsuario, float puntajeUsuario, String distanciaUsuario, float puntajeLibro, float saludLibro,
			boolean nuevo, boolean solicitado, int numeroSolicitudes, String tiempo, boolean reservado, boolean entregado, String edicion, int anio) {
		this.id_ofrecido = id_ofrecido;
		this.imagenLibro = imagenLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.usuario = usuario;
		this.imagenUsuario = imagenUsuario;
		this.puntajeUsuario = puntajeUsuario;
		this.distanciaUsuario = distanciaUsuario;
		this.puntajeLibro = puntajeLibro;
		this.saludLibro = saludLibro;
		this.nuevo = nuevo;
		this.solicitado = solicitado;
		this.numeroSolicitudes = numeroSolicitudes;
		this.tiempo = tiempo;
		this.reservado = reservado;
		this.entregado = entregado;
		this.edicion = edicion;
		this.anio = anio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public int getId_ofrecido() {
		return id_ofrecido;
	}

	public void setId_ofrecido(int id_ofrecido) {
		this.id_ofrecido = id_ofrecido;
	}

	public String getImagenLibro() {
		return imagenLibro;
	}

	public void setImagenLibro(String imagenLibro) {
		this.imagenLibro = imagenLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getImagenUsuario() {
		return imagenUsuario;
	}

	public void setImagenUsuario(String imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}

	public float getPuntajeUsuario() {
		return puntajeUsuario;
	}

	public void setPuntajeUsuario(float puntajeUsuario) {
		this.puntajeUsuario = puntajeUsuario;
	}

	public String getDistanciaUsuario() {
		return distanciaUsuario;
	}

	public void setDistanciaUsuario(String distanciaUsuario) {
		this.distanciaUsuario = distanciaUsuario;
	}

	public float getPuntajeLibro() {
		return puntajeLibro;
	}

	public void setPuntajeLibro(float puntajeLibro) {
		this.puntajeLibro = puntajeLibro;
	}

	public float getSaludLibro() {
		return saludLibro;
	}

	public void setSaludLibro(float saludLibro) {
		this.saludLibro = saludLibro;
	}

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	public boolean isSolicitado() {
		return solicitado;
	}

	public void setSolicitado(boolean solicitado) {
		this.solicitado = solicitado;
	}

	public int getNumeroSolicitudes() {
		return numeroSolicitudes;
	}

	public void setNumeroSolicitudes(int numeroSolicitados) {
		this.numeroSolicitudes = numeroSolicitados;
	}
	
	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
}


