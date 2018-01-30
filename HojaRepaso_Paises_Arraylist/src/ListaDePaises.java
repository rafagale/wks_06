import java.util.Arrays;

public class ListaDePaises {
	/*
	 * El constructor recibir� como par�metro el n�mero m�ximo de nombres que se
	 * pueden guardar en la lista. Para guardar los nombres se utilizar� un
	 * vector. Los nombres se almacenar�n en elementos consecutivos del vector.
	 */
	private Integer numeroPaises;
	private String[] paises;
	public int contadorPaises = 0;

	public ListaDePaises(Integer numeroPaises) {
		this.numeroPaises = numeroPaises;
		paises = new String[numeroPaises];
	}

	public void setPaises(String[] paises) {
		this.paises = paises;
	}

	public int getContadorPaises() {
		return contadorPaises;
	}

	public boolean anadir(String nombre) {
		boolean anadido = false;
		// para a�adir a la lista un nombre. Devuelve true si lo ha podido
		// a�adir y false en caso contrario.
		if (!existeNombre(nombre) && !estaLlena()) {
			anadido = true;
			paises[contadorPaises] = nombre;
			contadorPaises++;
		}
		return anadido;
	}

	@Override
	public String toString() {
		return "Paises: " + Arrays.toString(paises);
	}

	public boolean existeNombre(String nombre) {
		// para saber si el nombre existe en el array
		boolean existencia = false;
		for (int i = 0; i < paises.length; i++) {
			// Si uno coincide devuelve true
			if (paises[i] != null && paises[i].equals(nombre)) {
				existencia = true;
			}
		}
		return existencia;
	}

	public boolean borrar(String nombre) {
		boolean borrado = false;
		int posicionNombre = 0;
		// Devuelve true si ha podido borrar el nombre que recibe en el
		// par�metro y false en caso contrario. Al borrar un nombre hay que
		// desplazar un lugar a la izquierda
		// todos los elementos que quedan a la derecha del nombre que se ha
		// borrado.
		for (int i = 0; i < paises.length; i++) {
			if (paises[i] != null && paises[i].equals(nombre)) {
				borrado = true;
				posicionNombre = i;
			}
		}
		contadorPaises--;
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
		// Devuelve el nombre que se encuentra en la posici�n pasada como
		// par�metro (la primera es la posici�n 0). Devuelve null si no es una
		// posici�n v�lida.
		return paises[posicion];
	}// mostrar

	public Integer numElementos() {
		// Devuelve el n�mero de elementos que se almacenan en el vector
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
		// volverlo a copiar en uno con con el doble de capacidad
		String[] paisesAuxiliar = new String[paises.length];

		for (int i = 0; i < paises.length; i++) {
			if (paises[i] != null) {
				paisesAuxiliar[i] = paises[i];
			}
		}

		paises = new String[paises.length * 2];

		for (int i = 0; i < paisesAuxiliar.length; i++) {
			if (paisesAuxiliar[i] != null) {
				paises[i] = paisesAuxiliar[i];
			}
		}
	}// expandir

}// Class
