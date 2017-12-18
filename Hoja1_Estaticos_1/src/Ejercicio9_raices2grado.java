

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
		a = Metodos.pedirEntero("Introduce a");
		b = Metodos.pedirEntero("Introduce b");
		c = Metodos.pedirEntero("Introduce c");
		//Discriminante positivo
		if ( ((Math.pow(b, 2))-(4*a*c)) > 0) {
			System.out.println("Las raices son: ");
			System.out.print(Metodos.Ecuacion2G(a, b, c));
		} else {
			System.out.println("El discriminante es negativo");
		}
		//a  b  c
		//1 -2 -3
		// raices -> 3 y -1
	}// main

}// Class