import java.util.*;

/**
 * 
 * @author Rafa
 *
 */

public class Metodos {

	private static final double PI = 3.141592;
	
	/**
	 * Método para pedir un entero
	 * @param numero número ingresado por el usuario
	 * @return numero
	 */
	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num  = sc.nextInt();
		sc.close();
		return num;
	}// Pedir numero
	
	
	/**
	 * Método para calcular si un numero es primo o no
	 * @param numero número ingresado por el usuario
	 * @return true si es primo o false si no lo es
	 */
	public static boolean esPrimo(int numero) {
		// Un numero menor o igual que 1, no es primo.
		if (numero <= 1) {
			return false;
		}
		// Declaramos esta variable aqui ya que despues es usada"
		int cont = 0;
		for (int divisor = (int) Math.sqrt(numero); divisor > 1; divisor--) {
			// contabilizados los divisibles"
			if (numero % divisor == 0) {
				cont += 1;
			}
		}
		// Según el numero de divisibles es o no primo"
		if (cont >= 1) {
			return false;
		} else {
			return true;
		}
	}// esPrimo

	/**
	 * Método para calcular las cifras de un numero
	 * @param numero número ingresado por el usuario
	 * @return contador es el numero de cifras de @param
	 */
	public static int cuentaCifras(int numero) {
		int contador = 0;
		for (int i = numero; i > 0; i /= 10) {
			// Incrementamos el contador
			contador++;
		}
		return contador;
	}// cuentaCifras


	/**
	 * Método para calcular los divisores de un numero
	 * @param numero número ingresado por el usuario
	 * @return cont es el numero de divisores de @param
	 */
	public static int cuentaDivisores(int numero) {
		int cont = 0;
		for (int divisor = (int) Math.sqrt(numero); divisor > 1; divisor--) {
			// contabilizados los divisores
			if (numero % divisor == 0) {
				cont += 1;
			}
		}
		return cont;
	}// CuentaDivisores

	/**
	 * Método para calcular el factorial de un numero
	 * @param numero número ingresado por el usuario
	 * @return factorial es el factorial iterativo
	 */
	public static double factorial(int numero) {
		double factorial = 1;
		for (int i = 1; i <= numero; i++) {
			factorial *= i;
		}
		return factorial;
	}// Factorial iterativo


	/**
	 * Método para calcular el Maximo Comun Divisor
	 * @param num1 primer número ingresado por el usuario
	 * @param num2 segundo número ingresado por el usuario
	 * @return MCD que es el Maximo Comun Divisor entre num1 y num2
	 */
	static int mcd(int numero1, int numero2) {
		if (numero2 == 0)
			return numero1;
		else
			return mcd(numero2, numero1 % numero2);
	}// Maximo comun divisor recursivo


	/**
	 * Método para calcular el Mínimo Común Múltiplo
	 * @param num1 primer número ingresado por el usuario
	 * @param num2 segundo número ingresado por el usuario
	 * @return mcm que es el Mínimo Común Múltiplo entre num1 y num2
	 */
	public static int mcm(int num1, int num2) {
		int mcm = 0;
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		mcm = (a / mcd(a, b)) * b;
		return mcm;
	}// minimo comun multiplo recursivo

	/**
	 * Método para calcularlongitud, superficie o volumen de figuras
	 * @param1 radio radio ingresado por el usuario
	 * @param2 opcion 1,2,3 para el switch case
	 * @return resultado longitud, superficie o volumen
	 */
	public static double radio(int radio, int opcion) {
		double resultado;
		resultado = 0;
		switch (opcion) {
		case 1:
			resultado = 2 * PI * radio;
			break;
		case 2:
			resultado = PI * (radio * radio);
			break;
		case 3:
			resultado = 4 / 3 * PI * (radio ^ 3);
			break;
		}
		return resultado;
	}// Radio

	/**
	 * Método para calcular combinaciones de num1 sobre num2
	 * @param1 num1 primer número ingresado por el usuario
	 * @param2 num2 segundo número ingresado por el usuario
	 * @return combinaciones es el numero de combinaciones de num1 sobre num2
	 */
	public static double combinaciones(int num1, int num2) {
		double combinaciones = 0;
		combinaciones = factorial(num1) / (factorial(num2) * factorial(num1 - num2));
		return combinaciones;
	}// combinaciones

	/**
	 * Método para calcular raices en una ecuacion 2G
	 * @param1 num1 primer número ingresado por el usuario (a)
	 * @param2 num2 segundo número ingresado por el usuario (b)
	 * @param3 num3 tercer número ingresado por el usuario (c)
	 * @return raiz2 de la ecuacion 2G
	 */
	public static double Ecuacion2G(int a, int b, int c) {
		double raiz1, raiz2;
		raiz1 = (-b + Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a);
		raiz2 = (-b - Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a);
		System.out.print(raiz1 + " ");
		return raiz2;
	}// Ecuacion2G

}// Class