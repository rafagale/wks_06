import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Escribir un programa que llame a un método con los coeficientes de una
 * ecuación de segundo grado a, b, c y devuelva sus raíces en el caso de ser
 * reales.
 */

public class Ejercicio9_raices2grado {

	public static void main(String[] args) {
		int a, b,c;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce a");
		a = sc.nextInt();
		System.out.println("Introduce b");
		b = sc.nextInt();
		System.out.println("Introduce c");
		c = sc.nextInt();
		//Discriminante positivo
		if ( ((b*b)-(4*a*c)) > 0) {
			System.out.println("Las raices son: ");
			System.out.print(Metodos.Ecuacion2G(a, b, c));
		} else {
			System.out.println("El discriminante es negativo");
		}

		//1 -2 -3
	}// main

}// Class