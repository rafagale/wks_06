
public class Pila {

	private int[] datos;
	private static int contadorDatos = 0;

	public Pila() {
		datos = new int[500];
	}

	/**
	 * añadir un elemento a la PILA (encima, lógicamente) (ADD)
	 * 
	 * @param valor
	 */
	public void apilar(int valor) {

	}

	/**
	 * quitar un elemento de la PILA mostrándolo en pantalla (POP)
	 * 
	 * @param valor
	 */
	public void desaapilar(int valor) {

	}

	/**
	 * Comprobar si esta llena
	 * @return
	 */
	public boolean estaLlena() {
		if (contadorDatos == datos.length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Copiar una pila en otra
	 * 
	 * @param copia
	 */
	public Pila copy(Pila unaPila) {
		return unaPila;
	}

	/*
	 * Invertir una PILA (INV), es decir, el elemento cima pasa a ser el último
	 * y así sucesivamente hasta que el último esté el primero, es decir, en la
	 * cima. La pila inicial desaparece y hay que crear un nuevo objeto pila.
	 * Borrar toda la PILA. Método que nos indica con un boolean si la PILA esta
	 * vacía o no
	 */
}
