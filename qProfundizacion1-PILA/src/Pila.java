import java.util.Arrays;
import java.util.Random;

public class Pila {

	private int[] datos;
	private static int cima = 0;

	public Pila() {
		datos = new int[500];
		cima = 0;
	}

	public int apilar() {
		Random rand = new Random();
		datos[cima] = rand.nextInt(9 - 1 + 1) + 1;
		cima++;
		return cima;
	}

	public int desApilar() {
		datos[cima] = 0;
		cima--;
		return cima;
	}

	public boolean estaLlena() {
		if (cima == datos.length) {
			return true;
		} else {
			return false;
		}
	} // estaLlena

	public boolean estaVacia() {
		if (cima == 0) {
			return true;
		} else {
			return false;
		}
	}// estaVacia

	public Pila copy(Pila unaPila) {
		int [] unosDatos;
		Arrays.copyOf(datos, 500);
		return unaPila;
	}

	public static int[] invArray(int[] array) {
		int aux;
		for (int i = 0; i < array.length / 2; i++) {
			aux = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = aux;
		}
		return array;
	}

	public String borrar(Pila unaPila) {
		if (unaPila.estaVacia()) {
			datos[500] = datos[0];
			return "Pila borrada";
		} else {
			return "Pila no borrada";
		}
	}
	/*
	 * Invertir una PILA (INV), es decir, el elemento cima pasa a ser el último
	 * y así sucesivamente hasta que el último esté el primero, es decir, en la
	 * cima. La pila inicial desaparece y hay que crear un nuevo objeto pila.
	 * Borrar toda la PILA. Método que nos indica con un boolean si la PILA esta
	 * vacía o no
	 */
}
