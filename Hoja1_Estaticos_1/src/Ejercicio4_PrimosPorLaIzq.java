import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Dado un n�mero N que se pedir� por teclado y debe ser positivo, imprimir la
 * lista de todos los numero primos hasta dicho n�mero incluido. Hacer este
 * programa usando el m�todo primo que ya ten�is construido.
 */

public class Ejercicio4_PrimosPorLaIzq {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		num = sc.nextInt();
		System.out.print("Los n�meros primos por la izquierda de " +num + " son: ");
		for (int indice = 0; indice <= num; indice++) {
			if (Metodos.esPrimo(indice)) {
				System.out.printf("%3d",indice);
			}
		}

	}// main

}// Class