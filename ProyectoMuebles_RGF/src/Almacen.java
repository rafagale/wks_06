import java.util.Arrays;

/**
 * @author Rafa
 * @category Ejercicio Almacen con muebles
 */
public class Almacen {
	private String nombre;
	private String direccion;
	private Mueble[] muebles;

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param direccion
	 * @param muebles
	 */
	public Almacen(String nombre, String direccion, Mueble[] muebles) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.muebles = muebles;
	}

	/**
	 * @return un string con el nombre y direccion del almacen
	 */
	public String muestraAlmacen() {
		return " [nombre: " + nombre + ", direccion: " + direccion + "]";
	}

	/**
	 * @return un string con el nombre y direccion del almacen y los muebles que
	 *         posee
	 */
	public String verInfoTotal() {
		return "[nombre: " + nombre + "], muebles: " + Arrays.toString(muebles);
	}

}
