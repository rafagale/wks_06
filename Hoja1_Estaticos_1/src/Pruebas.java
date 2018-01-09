import java.util.Scanner;

public class Pruebas {

	public static void main(String[] args) {
		int numero;
		numero = pedirEntero("numero?");
		System.out.println("el numero es " +numero);
	}// main

	public static int pedirEntero(String mensaje) {
		String numero = "";
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(mensaje);
			numero = sc.nextLine();
		} while (!esNumerico(numero));
		num = Integer.parseInt(numero);
		return num;
	}// Pedir entero

	/**
	 * 
	 * @param cadena numerica
	 * @return true si solo tiene numeros, false si tiene mas cosas
	 */
	public static boolean esNumerico(String cadena) {
		boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}
		return resultado;
	}//esNumerico
}// Class
