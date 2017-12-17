import java.util.Scanner;
/**
 * 
 * @author Rafa
 *
 */
/*Se define el factorial de un número N como N*(N-1)*(N-2)*.......*3*2*1 . Hacer un programa
que lea un número N filtrando a que sea mayor que cero y calcule su factorial
La función a construir aquí se llamara factorial. El método main solo debe leer un valor y
devolver su factorial (versión iterativa).
La recursiva es la que da resultados parciales*/

public class Ejercicio3_Factorial {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero para calcular su factorial");
		num = sc.nextInt();
		System.out.println(Metodos.factorial(num));
	
		
	}// main

}// Class