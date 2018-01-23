import java.util.Arrays;

public class Libro {
	private String titulo;
	private Autor autores[];
	private Autor autor;
	private Double precio;
	private Integer cantidad;
	private static int contadorLibros = 0;

	public static int getContadorLibros() {
		return contadorLibros;
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


	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", {autores=" + Arrays.toString(autores) + "}, precio="
				+ precio + "€, cantidad=" + cantidad + "]";
	}

	//Añadir toString en la clase Autor
/*	public String cadenaLibroVariosAutores() {
		return "Libro [titulo=" + titulo + "]\n" + "{"+Arrays.toString(autores) + "}, precio=" + precio
				+ ", cantidad=" + cantidad + "]\n******************************************************************************";
	}*/
	public String cadenaLibroVariosAutores() {
		return "Libro [titulo=" + titulo + "]\n" + "{"+autor.cadenaAutor() + "}, precio=" + precio
				+ ", cantidad=" + cantidad + "]\n******************************************************************************";
	}

}
