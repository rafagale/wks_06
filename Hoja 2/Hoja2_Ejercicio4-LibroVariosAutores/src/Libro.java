import java.util.Arrays;

public class Libro {
	private String titulo;
	private Autor autores[];
	private Double precio;
	private Integer cantidad;
	private static int contadorLibros = 0;

	public static int getContadorLibros() {
		return contadorLibros;
	}

	public Libro(String titulo, Autor[] autores, Double precio) {
		this.titulo = titulo;
		this.autores = autores;
		this.precio = precio;
		contadorLibros++;
	}

	public Libro(String titulo, Autor[] autores, Double precio, Integer cantidad) {
		this.titulo = titulo;
		this.autores = autores;
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


	public Autor[] getAutores() {
		return autores;
	}
	//Añadir toString en la clase Autor
	public String cadenaLibro() {
		return "Libro [titulo=" + titulo + "]\n" + Arrays.toString(autores) + ", precio=" + precio
				+ ", cantidad=" + cantidad + "]\n******************************************************************************";
	}

}
