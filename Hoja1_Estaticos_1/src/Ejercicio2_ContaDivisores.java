import java.util.Scanner;
/**
 * 
 * @author Rafa
 *
 */
/*Dados dos n�meros P y Q que leeremos por teclado y que deben ser positivos, hacer un
programa que nos diga cual de los dos tiene m�s divisores, con un mensaje que diga �P tiene
mas divisores que Q� � viceversa.
Este programa debe llamar a un m�todo que calcule los divisores de un numero, y lo aplique
para P y para Q y luego compare y decida.*/

public class Ejercicio2_ContaDivisores {

	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero P");
		num1 = sc.nextInt();
		System.out.println("Introduce un numero Q");
		num2 = sc.nextInt();
		if (Metodos.cuentaDivisores(num1)>Metodos.cuentaDivisores(num2)) {
			System.out.println("P tiene m�s divisores que Q");
		}else if (Metodos.cuentaDivisores(num1)>Metodos.cuentaDivisores(num2)) {
			System.out.println("Q tiene m�s divisores que P");
		}else{
			System.out.println("Ambos tienen los mismos divisores");
		}
		
	}// main

}// Class