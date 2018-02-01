import java.util.Arrays;

public class ListaDePaises {
	/*
	 * El constructor recibirá como parámetro el número máximo de nombres que se
	 * pueden guardar en la lista. Para guardar los nombres se utilizará un
	 * vector. Los nombres se almacenarán en elementos consecutivos del vector.
	 */
	private Integer numeroPaises;
	private String[] paises;
	private int contadorPaises;

	public ListaDePaises(Integer numeroPaises) {
		this.numeroPaises = numeroPaises;
		paises = new String[numeroPaises];
		contadorPaises = 0;
	}

	public int getContadorPaises() {
		return contadorPaises;
	}

	public boolean anadir(String nombre) {
		boolean anadido = false;
		// para añadir a la lista un nombre. Devuelve true si lo ha podido
		// añadir y false en caso contrario.
		if (estaLlena()) {
			expandir();
		}
		if (!existeNombre(nombre)) {
			anadido = true;
			paises[contadorPaises] = nombre;
			contadorPaises++;
		}
		return anadido;
	}

	public boolean existeNombre(String nombre) {
		// para saber si el nombre existe en el array
		boolean existencia = false;
		for (int i = 0; i < paises.length; i++) {
			// Si uno coincide devuelve true
			if (paises[i] != null && paises[i].equalsIgnoreCase(nombre)) {
				existencia = true;
			}
		}
		return existencia;
	}

	public boolean borrar(String nombre) {
		boolean borrado = false;
		int posicionNombre = 0;
		// Devuelve true si ha podido borrar el nombre que recibe en el
		// parámetro y false en caso contrario. Al borrar un nombre hay que
		// desplazar un lugar a la izquierda
		// todos los elementos que quedan a la derecha del nombre que se ha
		// borrado.
		for (int i = 0; i < paises.length; i++) {
			if (paises[i] != null && paises[i].equalsIgnoreCase(nombre)) {
				paises[i] = null;
				borrado = true;
				posicionNombre = i;
				contadorPaises--;
			}
		}

		System.out.println(posicionNombre);
		if (borrado) {
			// si el pais se ha borrado, se mueven todos los elementos de la
			// derecha una posicion a la izquierda
			for (int i = posicionNombre; i < (paises.length - 1); i++) {
				paises[i] = paises[i + 1];
				paises[i + 1] = null;
			}
			return borrado;
		} else {
			return borrado;
		}
	}// Borrar

	public void vaciarLista() {
		for (int i = 0; i < paises.length; i++) {
			paises[i] = null;
		}
	}

	public String mostrar(int posicion) {
		// Devuelve el nombre que se encuentra en la posición pasada como
		// parámetro (la primera es la posición 0). Devuelve null si no es una
		// posición válida.
		if (paises.length-1 >= posicion && paises[posicion] != null) {
			return paises[posicion];
		} else {
			return "No hay nada en la posicion " + posicion;
		}

	}// mostrar

	public Integer numElementos() {
		// Devuelve el número de elementos que se almacenan en el vector
		int contador = 0;
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
		int contador = 0;
		boolean listaLLena = false;
		for (int i = 0; i < paises.length; i++) {
			if (paises[i] != null) {
				// Cuenta los elementos no null
				contador++;
			}
		}
		if (contador == paises.length) {
			listaLLena = true;
		}
		return listaLLena;
	}// estaLlena

	public void expandir() {
		// Copia el array de paises actual a uno auxiliar para posteriormente
		// volverlo a copiar en uno con con un elemento mas de capacidad

		paises = Arrays.copyOf(paises, paises.length + 1);
	}// expandir

	@Override
	public String toString() {
		return "Paises: " + Arrays.toString(paises);
	}
}// Class
