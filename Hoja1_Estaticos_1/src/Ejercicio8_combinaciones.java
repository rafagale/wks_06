import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Dados m elementos de un conjunto que se desean agrupar de n en n el número
 * combinatorio que nos define dicho numero de combinaciones posibles es
 * m!/(n!*(m-n)!), siendo siempre m >=n (hay que filtrarlo) Escribir un método
 * para que dados como parámetros m y n nos calcule el número de combinaciones
 * de m sobre n.
 */

public class Ejercicio8_combinaciones {

	public static void main(String[] args) {
		int m, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce m");
		m = sc.nextInt();
		System.out.println("Introduce n");
		n = sc.nextInt();
		if (m > n) {
			System.out.println("Las combinaciones de m sobre n son: " + Metodos.combinaciones(m, n));
		} else {
			System.out.println("m debe ser mayor que n");
		}

	}// main

}// Class