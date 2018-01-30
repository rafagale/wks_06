
import java.io.*;
//En este programa no controlamos los errores
import java.util.*;
public class Ejemplo01 {
public static void main(String args[]) throws IOException{
	int dividendo, divisor, cociente;
	String cadDividendo, cadDivisor;
	InputStreamReader via = new InputStreamReader(System.in);
	BufferedReader teclado = new BufferedReader(via);
	
	System.out.println("\nDividendo?");
	cadDividendo=teclado.readLine();
	dividendo=Integer.parseInt(cadDividendo);
	
	System.out.println("\nDivisor?");
	cadDivisor=teclado.readLine();
	divisor=Integer.parseInt(cadDivisor);
	
	cociente=dividendo/divisor;
	
	System.out.println("\n" + dividendo + " / " + divisor + " = " + cociente);
	
}//main
}//class
