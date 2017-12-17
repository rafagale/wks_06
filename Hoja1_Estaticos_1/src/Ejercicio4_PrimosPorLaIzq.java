import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Dado un número N que se pedirá por teclado y debe ser positivo, imprimir la
 * lista de todos los numero primos hasta dicho número incluido. Hacer este
 * programa usando el método primo que ya tenéis construido.
 */

public class Ejercicio4_PrimosPorLaIzq {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		num = sc.nextInt();
		System.out.print("Los números primos por la izquierda de " +num + " son: ");
		for (int indice = 0; indice <= num; indice++) {
			if (Metodos.esPrimo(indice)) {
				System.out.printf("%3d",indice);
			}
		}

	}// main

}// Class