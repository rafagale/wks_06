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
		CuentaCorriente cuentaNueva1, cuentaNueva2;
		cuentaNueva1 = new CuentaCorriente("001", 65);
		cuentaNueva2 = new CuentaCorriente("002", 0);
		System.out.println(cuentaNueva1.getNumCuenta());
		
		opcion = pedirEntero(
				"1-Ingresar en la cuenta 001\n2-Ingresar en la cuenta 002\n3-Retirar de la cuenta 001\n4-Retirar de la cuenta 002\n5-Visualizar");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Ingresar en la cuenta 001
				dinero = pedirDouble("Introduce la cantidad a ingresar");
				cuentaNueva1.ingresaEfectivo(dinero);
				break;
			case 2: // Ingresar en la cuenta 002
				dinero = pedirDouble("Introduce la cantidad a ingresar");
				cuentaNueva2.ingresaEfectivo(dinero);
				break;
			case 3:// Retirar en la cuenta 001
				dinero = pedirDouble("Introduce la cantidad a retirar");
				cuentaNueva1.retiraEfectivo(dinero);
				break;
			case 4:// Retirar en la cuenta 002
				dinero = pedirDouble("Introduce la cantidad a retirar");
				cuentaNueva2.retiraEfectivo(dinero);
				break;
			case 5: // Visualizar ambas cuentas
				System.out.println("El saldo de la cuenta " + cuentaNueva1.getNumCuenta() + " es "
						+ cuentaNueva1.getSaldo() + "€");
				System.out.println("El saldo de la cuenta " + cuentaNueva2.getNumCuenta() + " es "
						+ cuentaNueva1.getSaldo() + "€");
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
			opcion = pedirEntero(
					"1-Ingresar en la cuenta 001\n2-Ingresar en la cuenta 002\n3-Retirar de la cuenta 001\n4-Retirar de la cuenta 002\n5-Visualizar");
		}
	}// main

	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextInt();
		return num;
	}// Pedir int

	public static double pedirDouble(String mensaje) {
		double num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextDouble();
		return num;
	}// Pedir double

}// Class
