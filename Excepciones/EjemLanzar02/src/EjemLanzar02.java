/*Programa que pide una serie de numeros hasta que se tecleen letras.
 * Hay que mostrar la suma de todos los numeros dados*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class EjemLanzar02 {
	public static void main(String[] args) {
		int num, suma=0,conta=0;
		System.out.println("\nNumero?");
		boolean correcto=true;

		do{
			try{
				num=pedirEntero();
				suma=suma+num;
				conta++;
			}
			catch(NumberFormatException e){
				System.out.println("\nSe han insertado letras en lugar de numeros." +
						"Salimos del programa");
				correcto=false;
			}
			catch(IOException e){
				System.out.println("\nError en la entrada de datos.Salimos del programa");
				System.exit(0);
			}
		}while (correcto==true);
		if(conta==0)
			System.out.println("\nNo se muestra la suma porque no se ha insertado ningun numero valido");
		else
			System.out.println("\nLa suma de los numeros recibidos es " + suma);
	}//main
	static String pedirCadena() throws IOException{
		String cadena="";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(isr);
		cadena=teclado.readLine();
		return cadena;
	}//pedirCadena

	static int pedirEntero() throws IOException{
		String cadena;
		int num=0;
		cadena=pedirCadena();
		try{
		num=Integer.parseInt(cadena);
		}catch(NumberFormatException e){
			System.out.println("\nSe han insertado letras en lugar de numeros." +
					"Este mensaje esta en el metodo pedirEntero");
			throw e;
		}
		return num;
	}//pedirEntero
}//class
