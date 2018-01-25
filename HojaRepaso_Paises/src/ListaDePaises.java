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

	public  boolean anadir(String nombre) {
		int contador=0;
		boolean anadido=false;
		// para a�adir a la lista un nombre. Devuelve true si lo ha podido
		// a�adir y false en caso contrario.
		if (!existeNombre(nombre)) {
			anadido = true;
			paises[contador]=nombre;
		}
		contador++;
		return anadido;
	}
	@Override
	public String toString() {
		return "ListaDePaises [paises=" + Arrays.toString(paises) + "]";
	}

	public  boolean existeNombre(String nombre) {
		// para a�adir a la lista un nombre. Devuelve true si lo ha podido
		// a�adir y false en caso contrario.
		boolean existencia=false;
		for (int i = 0; i < paises.length; i++) {
			//Si uno coincide devuelve true
			if (paises[i]!=null && paises[i].equals(nombre)) {
				existencia=true;
			}
		}

		return existencia;
	}
	public boolean borrar(String nombre) {
		// Devuelve true si ha podido borrar el nombre que recibe en el
		// par�metro y false en caso contrario. Al borrar un nombre hay que
		// desplazar un lugar a la izquierda
		// todos los elementos que quedan a la derecha del nombre que se ha
		// borrado.
		return;
	}

	public void vaciarLista() {
		for (int i = 0; i < paises.length; i++) {
			paises[i] = null;
		}
		paises[numeroPaises] = paises[0];
	}

	public String mostrar(int posicion) {
		// Devuelve el nombre que se encuentra en la posici�n pasada como
		// par�metro (la primera es la posici�n 0). Devuelve null si no es una
		// posici�n v�lida.
		for (int i = 0; i < paises.length; i++) {
			if (paises[posicion] != null) {
				posicion = i;
			} else {
				return "null";
			}
		}
		return paises[posicion];
	}// mostrar


	public Integer numElementos() {
		// Devuelve el n�mero de elementos que se almacenan en el vector
		Integer contador = 0;
		for (int i = 0; i < paises.length; i++) {
			if (paises[i] != null) {
				contador++;
			}
		}
		return contador;
	}

	public Integer maxElementos() {
		return numeroPaises;
	}

	public boolean estaLlena() {
		boolean listaLLena = false;
		for (int i = 0; i < paises.length; i++) {
			//Si el ultimo elemento no es null est� vacia
			if (paises[i] != null) {
				listaLLena = true;
			}
		}
		return listaLLena;
	}
}//Class
