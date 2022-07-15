package modelos;

public class Libro {
	private int id;
	private String isbn;
	private String autor;
	private String titulo;
	private int edicion;
	private int año;
	private float puntaje;
	private String foto;

	public Libro(int id, String isbn, String autor, String titulo, int año, int edicion, float puntaje) {
		this.id = id;
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.edicion = edicion;
		this.año = año;
		this.puntaje = puntaje;
	}
	
	public Libro(String isbn, String autor, String titulo, int año, int edicion) {
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.edicion = edicion;
		this.año = año;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}

