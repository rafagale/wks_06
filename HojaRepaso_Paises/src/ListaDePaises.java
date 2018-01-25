import java.util.Arrays;

public class ListaDePaises {
	/*
	 * El constructor recibirá como parámetro el número máximo de nombres que se
	 * pueden guardar en la lista. Para guardar los nombres se utilizará un
	 * vector. Los nombres se almacenarán en elementos consecutivos del vector.
	 */
	private Integer numeroPaises;
	private String[] paises;
	public static int contadorPaises = 0;

	public ListaDePaises(Integer numeroPaises) {
		this.numeroPaises = numeroPaises;
		paises = new String[numeroPaises];
	}


	public String[] getPaises() {
		return paises;
	}


	public void setPaises(String[] paises) {
		this.paises = paises;
	}


	public static int getContadorPaises() {
		return contadorPaises;
	}

	public static boolean anadir(String nombre) {
		// ara añadir a la lista un nombre. Devuelve true si lo ha podido
		// añadir y false en caso contrario.
		return;
	}

	public static boolean borrar(String nombre) {
		// Devuelve true si ha podido borrar el nombre que recibe en el
		// parámetro y false en caso contrario. Al borrar un nombre hay que
		// desplazar un lugar a la izquierda
		// todos los elementos que quedan a la derecha del nombre que se ha
		// borrado.
		return;
	}

	public static void vaciarLista() {
		// Borra todos los nombres de la lista.
	}

	public static String anadir(int posicion) {
		//Devuelve el nombre que se encuentra en la posición pasada como
		//parámetro (la primera es la posición 0). Devuelve null si no es una posición válida.
		return;
	}

	public static Integer numElementos() {
		//Devuelve el número de elementos que se almacenan en el vector.
		return;
	}

	public static Integer maxElementos() {
		//Devuelve el número máximo de elementos que podemos guardar en el vector.
		return;
	}

	public static boolean estaLlena() {
		//Si ya no se puede guardar ningún nombre más devuelve true, en caso
		//contrario devuelve false
		return;
	}
}
