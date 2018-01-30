import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class EjemLanzar01 {


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
		catch(IOException e){
			System.out.println("\nSalimos del programa");
			System.exit(0);
		}
	}//main
	static String pedirCadena() throws IOException{
		String cadena="";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(isr);
		//try{
			cadena=teclado.readLine();
		//}catch(IOException e){
		//	System.out.println("\nEl programa se cierra debido a un error grave");
		//	System.exit(0);
		//}
		return cadena;
	}//pedirCadena
	
	static int pedirEntero() throws IOException{
		String cadena;
		int num=0;
		cadena=pedirCadena();
		//try{
		num=Integer.parseInt(cadena);
		//}catch(NumberFormatException e){
		//	System.out.println("\nSe han insertado letras en lugar de numeros." +
		//			"Este mensaje esta en el metodo pedirEntero");
		//	System.exit(0);//ver que pasa si se comenta esta linea
		//}
		return num;
	}//pedirEntero
}//class
