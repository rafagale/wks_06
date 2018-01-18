
public class Libro {
	private String titulo;
	private Autor autor;
	private Double precio;
	private Integer cantidad;
	private static int contadorLibros = 0;

	public static int getContadorLibros() {
		return contadorLibros;
	}

	public Libro(String titulo, Autor autor, Double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		contadorLibros++;
	}

	public Libro(String titulo, Autor autor, Double precio, Integer cantidad) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.cantidad = cantidad;
		contadorLibros++;
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

	public String cadenaLibro() {
		return "Libro [titulo=" + titulo + ", autor=" + autor.cadenaAutor() + ", precio=" + precio + "€, cantidad="
				+ cantidad + "]";
	}

}
