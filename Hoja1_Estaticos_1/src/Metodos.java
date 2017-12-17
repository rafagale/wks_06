/**
 * 
 * @author Rafa
 *
 */

public class Metodos {
	private static final double PI = 3.141592;

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

	public static int cuentaCifras(int numero) {
		int contador = 0;
		for (int i = numero; i > 0; i /= 10) {
			// Incrementamos el contador
			contador++;
		}
		return contador;
	}// cuentaCifras

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

	public static double factorial(int numero) {
		double factorial = 1;
		for (int i = 1; i <= numero; i++) {
			factorial *= i;
		}
		return factorial;
	}// Factorial iterativo

	static int mcd(int numero1, int numero2) {
		if (numero2 == 0)
			return numero1;
		else
			return mcd(numero2, numero1 % numero2);
	}// MCD recursivo

	public static int mcm(int num1, int num2) {
		int mcm = 0;
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		mcm = (a / mcd(a, b)) * b;
		return mcm;
	}// mcm recursivo

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

	public static double combinaciones(int num1, int num2) {
		double combinaciones = 0;
		combinaciones = factorial(num1) / (factorial(num2) * factorial(num1 - num2));
		return combinaciones;
	}// combinaciones
	
	public static double Ecuacion2G(int a, int b, int c) {
		double raiz1, raiz2;
		raiz1=(-b+Math.sqrt((b*b)-(4*a*c)))/(2*a);
		raiz2=(-b-Math.sqrt((b*b)-(4*a*c)))/(2*a);
		return raiz1;
	}// Ecuacion2G

}// Class