import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * 
 * Escribir un m�todo que con dos par�metros enteros p y q nos devuelva el m.c.d
 * (m�ximo com�n divisor) de ambos.
 */

public class Ejercicio5_MCD {

	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero P");
		num1 = sc.nextInt();
		System.out.println("Introduce un numero Q");
		num2 = sc.nextInt();
		System.out.println("El Maximo comun divisor es: ");
		System.out.println(Metodos.mcd(num1, num2));

	}// main

}// Class