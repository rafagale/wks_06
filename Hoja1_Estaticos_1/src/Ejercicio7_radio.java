import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Escribir un método al que se le dé como parámetro un valor r que representa
 * el radio de una, figura una opción y un dato entero que será 1/2/3. El método
 * debe devolver: -En el caso opcion1 la longitud del circulo de radio r dada
 * por la expresión 2*pi*r - En el caso opción 2 la superficie del circulo dada
 * por la expresión pi*r2 -En el caso opción 3 el volumen de una esfera de radio
 * r dada por la expresión 4/3*pi*r3.
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