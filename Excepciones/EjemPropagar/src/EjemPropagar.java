import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class EjemPropagar {


	public static void main(String[] args) {
		int num1;
		System.out.println("\nNumero?");
		try{
			num1=pedirEntero();
			System.out.println("\nEl numero que se ha dado es " + num1);
		}
		catch(NumberFormatException e){
			System.out.println("\nSe han insertado letras en lugar de numeros." +
					"Este mensaje esta en el metodo main");
		}
	}//main
	static String pedirCadena(){
		String cadena="";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(isr);
		try{
			cadena=teclado.readLine();
		}catch(IOException e){
			System.out.println("\nEl programa se cierra debido a un error grave");
			System.exit(0);
		}
		return cadena;
	}//pedirCadena
	
	static int pedirEntero(){ // no controla el error en caso de introducir letras
		String cadena;
		int num=0;
		cadena=pedirCadena();
		
		num=Integer.parseInt(cadena);// si se produce error se propaga automáticamente al main
		
		return num;
	}//pedirEntero
}//class
