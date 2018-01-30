
import java.io.*;

import java.util.*;
public class Ejemplo02 {
	public static void main(String args[]) throws IOException{
		int dividendo, divisor, cociente;
		String cadDividendo, cadDivisor;
		InputStreamReader via = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(via);
		try{

			System.out.println("\nDividendo?");
			cadDividendo=teclado.readLine();
			dividendo=Integer.parseInt(cadDividendo);

			System.out.println("\nDivisor?");
			cadDivisor=teclado.readLine();
			divisor=Integer.parseInt(cadDivisor);

			cociente=dividendo/divisor;

			System.out.println("\n" + dividendo + " / " + divisor + " = " + cociente);
		}
		catch(NumberFormatException e){
			System.out.println("\nSe han introducido caracteres no numéricos");
		}
		catch(ArithmeticException ex){
			System.out.println("\nDivisión entre cero");
		}
		System.out.println("*************");
	}//main
}//class
