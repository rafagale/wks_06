import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Escribir un programa que llame a un m�todo con los coeficientes de una
 * ecuaci�n de segundo grado a, b, c y devuelva sus ra�ces en el caso de ser
 * reales.
 */

public class Ejercicio9_raices2grado {

	public static void main(String[] args) {
		int m, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce m");
		m = sc.nextInt();
		System.out.println("Introduce n");
		n = sc.nextInt();
		if (m >= n) {
			System.out.println("Las combinaciones de m sobre n son: " + Metodos.combinaciones(m, n));
		} else {
			System.out.println("m debe ser mayor o igual que n");
		}

	}// main

}// Class