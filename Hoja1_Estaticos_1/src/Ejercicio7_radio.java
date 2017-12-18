import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Escribir un m�todo al que se le d� como par�metro un valor r que representa
 * el radio de una, figura una opci�n y un dato entero que ser� 1/2/3. El m�todo
 * debe devolver: -En el caso opcion1 la longitud del circulo de radio r dada
 * por la expresi�n 2*pi*r - En el caso opci�n 2 la superficie del circulo dada
 * por la expresi�n pi*r2 -En el caso opci�n 3 el volumen de una esfera de radio
 * r dada por la expresi�n 4/3*pi*r3.
 */

public class Ejercicio7_radio {

	public static void main(String[] args) {
		int r, opcion;
		Scanner sc = new Scanner(System.in);
		r = Metodos.pedirEntero("Introduce el radio");
		do {
			System.out.println("Elige una de las siguientes opciones:");
			System.out.println("1-Longitud del circulo de radio: " + r);
			System.out.println("2-Superficie del circulo de radio: " + r);
			System.out.println("3-Volumen de la esfera de radio: " + r);
			opcion = sc.nextInt();
		} while (opcion != 1 && opcion != 2 && opcion != 3);
		System.out.println("El resultado es: " + Metodos.radio(r, opcion));

	}// main

}// Class