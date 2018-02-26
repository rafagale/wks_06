
public class Libro {
	private String titulo;
	private Autor autor;
	private double precio;
	private Integer cantidad;
	private static int contadorLibros;
	
	public Libro(String titulo, Autor autor, double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		cantidad = 0;
		contadorLibros++;
	}

	public Libro(String titulo, Autor autor, double precio, Integer cantidad) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public static int getContadorLibros() {
		return contadorLibros;
	}

	public String cadenaLibro() {
		String cadena = "Libro [titulo = " + titulo + ",\n" + "Autor [nombre = " + autor.getNombre() + ", email = "
				+ autor.getEmail() + ", genero = " + autor.getGenero() + "]\n" + "precio = " + precio + " cantidad = "
				+ cantidad + "]";
		return cadena;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

}// Libro
