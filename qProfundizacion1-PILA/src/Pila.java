import java.util.Arrays;
import java.util.Random;

public class Pila {

	private int[] datos;
	private static int cima = 0;

	public Pila() {
		datos = new int[500];
		cima = 0;
	}

	public static int getCima() {
		return cima;
	}

	public void apilar() {
		Random rand = new Random();
		datos[cima] = rand.nextInt(9 - 1 + 1) + 1;
		cima++;
	}

	public int desApilar() {
		int ultimoElemento;
		ultimoElemento = datos[cima];
		datos[cima - 1] = 0;
		cima--;
		return ultimoElemento;
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
	
	public void copiar(Pila nueva) {
		nueva.datos = Arrays.copyOf(this.datos, this.datos.length);
		nueva.cima = this.cima;
	}// copiar

	public  String invertir() {
/*		 * Invertir una PILA (INV), es decir, el elemento cima pasa a ser el último
		 * y así sucesivamente hasta que el último esté el primero, es decir, en la
		 * cima. La pila inicial desaparece y hay que crear un nuevo objeto pila.*/
		int[] aux = new int[datos.length];
		for (int i = 0, j = aux.length - 1; i < datos.length; i++, j--) {
			aux[i] = datos[j];
		}
		return Arrays.toString(aux);
	}

	public String borrar() {
		for (int i = 0; i < datos.length; i++) {
			datos[i] = 0;
		}
		return "Pila borrada";
	}

	@Override
	public String toString() {
		return "Pila: " + Arrays.toString(datos);
	}

	/*

	 * Borrar toda la PILA. Método que nos indica con un boolean si la PILA esta
	 * vacía o no
	 */
}
