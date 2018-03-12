/**
 * @author Rafa
 * @category Ejercicio Almacen con muebles
 */
public class Mueble {
	private Integer codigo;
	private String descripcion;
	private Integer ancho;
	private Integer alto;
	private Integer fondo;
	private static Integer siguiente = 1;

	/**
	 * Constructor
	 * @param descripcion
	 * @param ancho
	 * @param alto
	 * @param fondo
	 */
	public Mueble(String descripcion, Integer ancho, Integer alto, Integer fondo) {
		this.descripcion = descripcion;
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		codigo = getSiguiente();
		siguiente++;
	}

	/**
	 * @return contador de muebles
	 */
	public static Integer getSiguiente() {
		return siguiente;
	}

	/**
	 * @return datos del mueble
	 */
	public String muestraMueble() {
		return " [codigo: " + codigo + ", descripcion: " + descripcion + ", ancho=" + ancho + " cm, alto=" + alto
				+ " cm, fondo=" + fondo + " cm]";
	}

	@Override
	public String toString() {
		return " [codigo: " + codigo + ", descripcion: " + descripcion + "]";
	}

}