
public class Libro {
	private String titulo;
	private Autor autor;
	private Double precio;
	private Integer cantidad;

	Libro(String titulo, Autor autor, Double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	Libro(String titulo, Autor autor, Double precio, Integer cantidad) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.cantidad = cantidad;
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

	public String candenaLibro() {
		return "LIBRO: [Titulo: " + titulo + " Precio: " + precio + " Cantidad: " + cantidad + " " + autor.cadenaAutor()+ "]  ";
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
