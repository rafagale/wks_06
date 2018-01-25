import java.util.Arrays;

public class ListaDePaises {
	/*
	 * El constructor recibirá como parámetro el número máximo de nombres que se
	 * pueden guardar en la lista. Para guardar los nombres se utilizará un
	 * vector. Los nombres se almacenarán en elementos consecutivos del vector.
	 */
	private Integer numeroPaises;
	private String nombrePais;
	public static int contadorPaises = 0;

	/**
	 * @param numeroPaises
	 */
	public ListaDePaises (Integer numeroPaises) {
		this.numeroPaises = numeroPaises;
		this.nombrePais = 
		contadorPaises++;
	}
	
	public Boolean anadir(String nombre) {
		// Para añadir a la lista un nombre. Devuelve true si lo ha podido
		// añadir y false en caso contrario.
		for (int i = 0; i < numeroPaises; i++) {
			if (ListaDePaises[i].equals(nombre)) {
				
			}
		}
	}

	public Boolean borrar(String nombre) {
		// Devuelve true si ha podido borrar el nombre que recibe en el
		// parámetro y false en caso contrario. Al borrar un nombre hay que
		// desplazar un lugar a la izquierda todos los elementos que quedan a la
		// derecha del nombre que se ha borrado.

	}

	public void vaciarLista() {
		// Borra todos los nombres de la lista.
	}

	public String mostrar(int posicion) {
		// Devuelve el nombre que se encuentra en la posición pasada como
		// parámetro (la primera es la posición 0). Devuelve null si no es una
		// posición válida.
	}

	public Integer numElementos() {
		// Devuelve el número de elementos que se almacenan en el vector.
	}

	public Integer maxElementos() {
		// Devuelve el número máximo de elementos que podemos guardar en el
		// vector.
	}

	public Boolean estaLlena() {
		// Si ya no se puede guardar ningún nombre más devuelve true, en caso
		// contrario devuelve false.

	}
}
