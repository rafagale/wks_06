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

public class Ejercicio6_MCM {

	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		num1 = Metodos.pedirEntero("Introduce un numero P");
		num2 = Metodos.pedirEntero("Introduce un numero P");
		System.out.println("El minimo comum multiplo es: ");
		System.out.println(Metodos.mcm(num1, num2));

	}// main

}// Class