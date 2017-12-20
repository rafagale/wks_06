import java.util.*;
/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorrienteMain {

	public static void main(String[] args) {
		double dinero;
		int opcion;
		String mensaje="";
		CuentaCorriente cuentaNueva1, cuentaNueva2;

		cuentaNueva1 = new CuentaCorriente("001", 0);
		cuentaNueva2 = new CuentaCorriente("002", 0);
		
		menu("Este es el menu");
		
	}//main
	
	
	

	public static int menu (String mensaje){
		int opcion;
	opcion=	pedirEntero("Elige una opcion");
		switch (opcion) {
		case 1: //Ingresar en la cuenta 001
			System.out.println("hola");
			break;
		case 2: //Ingresar en la cuenta 002
			
			break;
		case 3://Retirar en la cuenta 001
			
			break;
		case 4://Retirar en la cuenta 002
			
			break;
		case 5: //Visualizar ambas cuentas
			
			break;
			
		default:
System.out.println("Opcion incorrecta");
		}
		return opcion;
	}
	
	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num  = sc.nextInt();
		return num;
	}// Pedir numero
	
}//Class
