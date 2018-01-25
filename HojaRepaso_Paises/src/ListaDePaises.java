import java.util.Arrays;

public class ListaDePaises {
	/*
	 * El constructor recibir� como par�metro el n�mero m�ximo de nombres que se
	 * pueden guardar en la lista. Para guardar los nombres se utilizar� un
	 * vector. Los nombres se almacenar�n en elementos consecutivos del vector.
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
		// ara a�adir a la lista un nombre. Devuelve true si lo ha podido
		// a�adir y false en caso contrario.
		return;
	}

	public static boolean borrar(String nombre) {
		// Devuelve true si ha podido borrar el nombre que recibe en el
		// par�metro y false en caso contrario. Al borrar un nombre hay que
		// desplazar un lugar a la izquierda
		// todos los elementos que quedan a la derecha del nombre que se ha
		// borrado.
		return;
	}

	public static void vaciarLista() {
		// Borra todos los nombres de la lista.
	}

	public static String anadir(int posicion) {
		//Devuelve el nombre que se encuentra en la posici�n pasada como
		//par�metro (la primera es la posici�n 0). Devuelve null si no es una posici�n v�lida.
		return;
	}

	public static Integer numElementos() {
		//Devuelve el n�mero de elementos que se almacenan en el vector.
		return;
	}

	public static Integer maxElementos() {
		//Devuelve el n�mero m�ximo de elementos que podemos guardar en el vector.
		return;
	}

	public static boolean estaLlena() {
		//Si ya no se puede guardar ning�n nombre m�s devuelve true, en caso
		//contrario devuelve false
		return;
	}
}
