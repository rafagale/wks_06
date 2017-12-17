import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Dados m elementos de un conjunto que se desean agrupar de n en n el n�mero
 * combinatorio que nos define dicho numero de combinaciones posibles es
 * m!/(n!*(m-n)!), siendo siempre m >=n (hay que filtrarlo) Escribir un m�todo
 * para que dados como par�metros m y n nos calcule el n�mero de combinaciones
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