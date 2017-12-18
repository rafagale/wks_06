import java.util.Scanner;
/**
 * 
 * @author Rafa
 *
 */

/*Hacer un programa que lea un número N y nos escriba en la pantalla mediante un mensaje si es
ó no primo (NOTA: Número primo es aquél que es divisible solo por sí mismo y por, la unidad)
Desarrollar este programa creando un método llamado primo que devuelva true si el número
es primo y false si no lo es.*/

public class Ejercicio1_Primo {

	public static void main(String[] args) {
		int num ;
		
		num=Metodos.pedirEntero("Introduce un numero");
		
		if (Metodos.esPrimo(num)) {
			System.out.println("Es primo");
		}else{
			System.out.println("No es primo");
		}

	}//main

}//Class

