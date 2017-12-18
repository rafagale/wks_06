import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * 
 * Escribir un método que con dos parámetros enteros p y q nos devuelva el m.c.d
 * (máximo común divisor) de ambos.
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